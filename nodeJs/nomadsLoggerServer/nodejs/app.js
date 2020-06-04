const serverExpress = require('./server/expressServer.js');
const fs = require('fs')
const url = require('url');
const XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

const port = 8081;
const host = "0.0.0.0"

const mongodb = require("./mongodb/mongodb")
mongo = new mongodb("mongodb://logServer:logServerPassword@35.181.46.56:27017");
mongo.connect(null, null);

function root(req, res) {
    res.sendFile(__dirname + "/html/index.html");
}

function notFound(req, res) {
    const path = __dirname + "/html/" + url.parse(req.url).pathname;
    console.log(path);
    try {
        if (fs.existsSync(path)) {
            res.sendFile(path);
        }
    } catch (err) {
        res.status(404).send("404 : page not found");
    }
}

function notFoundJson(req, res) {
    res.status(404).json({ "message": "404 : page not found" });
}

//sendToLogstash({"sasa":"sasa"});

function sendToLogstash(json){
    
      
      var oReq = new XMLHttpRequest();
      oReq.onload = function reqListener () {
        console.log("ok");
      }
      oReq.open("get", "http://35.181.46.56:8091/", true);
      oReq.send(JSON.stringify(json));
}

function makeJsonToSave(req) {
    let json = {
        date: new Date(),
        from: "unknown",
        methode: req.body.methode,
        className: req.body.className,
        classSimpleName: req.body.classSimpleName,
        object: req.body.object
    };
    return json;
}

function saveJson(json, res) {
    try {
        mongo.save(json);
        res.json({ logOk: true });
    } catch (error) {
        res.json({ logOk: false, error: error });
    }
}

function logDatabase(req, res) {
    let json = makeJsonToSave(req);
    saveJson(json, res);

    sendToLogstash(json);

}

function logDatabaseRest(req, res) {
    let json = makeJsonToSave(req);
    json.from = "Rest_macro_service";
    saveJson(json, res);
}

function logDatabaseCurrency(req, res) {
    let json = makeJsonToSave(req);
    json.from = "Currency_micro_service";
    saveJson(json, res);
}


function logDatabaseAnnuaire(req, res) {
    let json = makeJsonToSave(req);
    json.from = "Annuaire_micro_service";
    saveJson(json, res);
}


function logDatabaseStock(req, res) {
    let json = makeJsonToSave(req);
    json.from = "Stock_micro_service";
    saveJson(json, res);
}


function logDatabaseWeb(req, res) {
    let json = makeJsonToSave(req);
    json.from = "Web_application";
    saveJson(json, res);
}

function parseQuery(query){
    mongoQuery={};
    if(query.from){
        mongoQuery.from=query.from;
    }
    if(query.methode){
        mongoQuery.methode=query.methode;
    }
    if(query.className){
        mongoQuery.className=query.className;
    }
    if(query.classSimpleName){
        mongoQuery.classSimpleName=query.classSimpleName;
    }
    if(query.date){
        if(query.gt){
            mongoQuery.date={"$gte":{"$date" : new Date(query.date)}};
        }else{
            mongoQuery.date={"$lte":{"$date" : new Date(query.date)}};
        }
    }
    return mongoQuery;
}

function getDatabaseCallback(result,query){
    query.res.json(result);
}

function findDatabase(req,res){
    let query={callback:getDatabaseCallback,res:res,req:req};
    query.query=parseQuery(req.query);
    mongo.read(query);
}

function uniqueDatabase(req,res){
    let query={callback:getDatabaseCallback,res:res,req:req};
    if(req.query.unique) {
        query.query=req.query.unique;
        mongo.distinct(query);
    }else{
        res.json({error:"enter value ?unique=methode for example"})
    }
}

function countDatabase(req,res){
    let query={callback:getDatabaseCallback,res:res,req:req};
    query.query=parseQuery(req.query);
    mongo.count(query);
}

//http://127.0.0.1:9090/api/log/database
const config = [
    //pages api router post logs
    { path: "/log/database", func: logDatabase, methode: "post", who: "apiRouter" },
    { path: "/log/database/rest", func: logDatabaseRest, methode: "post", who: "apiRouter" },
    { path: "/log/database/currency", func: logDatabaseCurrency, methode: "post", who: "apiRouter" },
    { path: "/log/database/annuaire", func: logDatabaseAnnuaire, methode: "post", who: "apiRouter" },
    { path: "/log/database/stock", func: logDatabaseStock, methode: "post", who: "apiRouter" },
    { path: "/log/database/web", func: logDatabaseWeb, methode: "post", who: "apiRouter" },

    //pages api router get logs
    { path: "/log/database", func: findDatabase, methode: "get", who: "apiRouter" },
    { path: "/log/database/unique", func: uniqueDatabase, methode: "get", who: "apiRouter" },
    { path: "/log/database/count", func: countDatabase, methode: "get", who: "apiRouter" },
 

    //pages html router
    { path: "/", func: root, methode: "get", who: "htmlRouter" },

    //404 pages
    { path: "*", func: notFound, methode: "get", who: "htmlRouter" },
    { path: "*", func: notFoundJson, methode: "get", who: "apiRouter" },

    //enable routers
    { path: "/api", addObject: "apiRouter", methode: "use", who: "app" },
    { path: "/", addObject: "htmlRouter", methode: "use", who: "app" },

];

function onStartServer() {
    console.log("Express Server is Running on port " + port);
}

const serveur1 = new serverExpress(host, port, config, onStartServer);
