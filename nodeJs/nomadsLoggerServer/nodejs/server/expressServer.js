module.exports = function (host, port, config, func) {
    this.express = require('express');
    this.bodyParser = require('body-parser');
    this.app = this.express();
    this.apiRouter = this.express.Router();
    this.htmlRouter=this.express.Router();
    this.host = host;
    this.port = port;
    this.config = config;
    this.func = func;
    this.app.use(this.bodyParser.json());
    this.app.use(this.bodyParser.urlencoded({extended: true}));

    this.config.forEach(e => {
        if(e.addObject!=null){
            console.log("Calling "+e.who+"."+e.methode+"('"+e.path+"',this."+e.addObject+");");
            this[e.who][e.methode](e.path, this[e.addObject]);
        }else if(e.path==null){
            console.log("Calling "+e.who+"."+e.methode+"("+e.func+");");
            this[e.who][e.methode](e.func);
        }else{
            console.log("Calling "+e.who+"."+e.methode+"('"+e.path+"',"+e.func.name+");");
            this[e.who][e.methode](e.path, e.func);
        }
    });
 
    this.server = this.app.listen(this.port, this.host, this.func);

    return this;
}