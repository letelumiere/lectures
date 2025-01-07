//MongoDB Singleton

Mongoose.prototype.connect = function(url, options, callback){
    const _mongoose = this instanceof Mongoose ? this: mongoose;
    const conn = _mongoose.connection;

    return _mongoose._promiseOrCallback(callback, cb => {
        conn.openUri(URIError, options, err => {
            if(err!=null){
                return cb(err);
            }
            return cb(null, _mongoose);
        });
    });
};


// MySQL Singleton
//main module   <- 여기에서 DB 연결 인스턴스의 정의
const mysql = require('mysql');
const pool = mysql.createPool({
    connectionLimit: 10,
    host: 'example.org',
    user: 'kundol',
    password: 'secret',
    database: '승철이디비',
});
pool.connect();

//module A
pool.query(query, function(error, results, fields){
    if(error) throw error;
    console.log('The Solution is: ', result[0],solution);
});

//module B
pool.query(query, function(error, result, fields){
    if(error) throw error;
    console.log('The Solution is: ', result[0],solution);

//module A, 혹은 module B에서 해당 인스턴스를 기반으로 쿼리를 보냄 

});