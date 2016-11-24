const express = require('express')  
const fs = require('fs')
const async = require('async')
const path = "../src/data/";
const app = express()  
const port = 3000

app.get('/info', (req, res, next) => {  
  fs.readdir(path, (err, data) => {
    if (err)
      next(err)
    else if (data.length == 0)
      res.sendStatus(404);
    else {
      var dir = [];
      async.series([
        (callback) => {
          data.forEach((f) => {
              dir.push(path + f);
          });
          callback(null, null);
        }, 
        (callback) => {
          var epa = [];
          dir.forEach((c) => {
            epa.push(fs.readFileSync(c, 'utf8'));
          })
          callback(null, epa);
        }
      ], (err, resp) => {
        if (err)
          next(err)
        if (resp)
          res.json(trataRetorno(resp[1]));
      })
    }
  })
})

function trataRetorno(ret) {
  var obj = [];
  ret.forEach((r) => {
    if (r != null) {
      r.replace("\r\n", "");
      var sep = r.split(";");
      var IDENTIFICADOR = sep[0].split("&")[1];
      var FORA = sep[1].split("&")[1];
      var POSICAO = sep[2].replace("\r\n", "").split("|");
      var posX = POSICAO[0].split("X-")[1];
      var posY = POSICAO[1].split("Y-")[1]; 
      obj.push({id: IDENTIFICADOR, out: FORA, pos: {x:posX , y: posY}});
    }
  })
  return (obj);
}

var allowCrossDomain = function(req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
}
app.use(allowCrossDomain);

app.listen(port, (err) => {  
  if (err) {
    return console.log('Aconteceu algo de errado: ', err)
  }

  console.log(`Servidor ligado na porta ${port}`)
})
