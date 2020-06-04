module.exports = function (url){

    this.url=url;
    this.MongoClient = require("mongodb").MongoClient;
    this.deprec = {
        useUnifiedTopology: true,
        useNewUrlParser: true,
    };
    this.db=null;
    this.client=null;
    this.collection="service_rest";

    this.connect=function(callback,params){
        this.MongoClient.connect(this.url, this.deprec, (err , client)=> {
            if (err) throw err;
            this.client=client;

            this.db = this.client.db("nomads");

            if(callback!=null){
                callback(params);
            }
        });
    };

    this.save=function (json){
        if(this.db==null){
            this.connect(this.save,url);
        }else{

            this.db.collection(this.collection).insertOne(json, (err, result) => {
                if (err) {
                    return console.log('Unable to insert Todo err=' + err);
                }
                console.log(JSON.stringify(result.ops, undefined, 2));
            });
        }
    };

    this.read=function(query){
        if(this.db==null){
            this.connect(this.read,query);
        }else{
            this.db.collection(this.collection).find(query.query).toArray(function (err, result) {
                if (err) throw query.callback({error:err});
                query.callback(result,query);
            });
        }
    };

    this.count=function(query){
        if(this.db==null){
            this.connect(this.count,query);
        }else{
            this.db.collection(this.collection).count(
           query.query,function (err, result) {
                if (err) throw query.callback({error:err});
                query.callback({result:result},query);
            });
        }
    };

    this.distinct=function(query){
        if(this.db==null){
            this.connect(this.distinct,query);
        }else{
            this.db.collection(this.collection).distinct(query.query,{},function (err, result) {
                if (err) throw query.callback({error:err});
                query.callback(result,query);
            });
        }
    };

    this.close=function(){
        if(this.db!=null){
            this.client.close();

            this.client=null;
            this.db=null;
        }
    };
   
};