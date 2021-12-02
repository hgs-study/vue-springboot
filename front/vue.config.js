const path = require('path');

module.exports = {
    outputDir : '../src/main/resources/static',

    devServer : {
        port : 3030,
        proxy : {
            '/api' : {
                target : 'http://localhost:8080'
            }
        }
    },

    configureWebpack : { 
        resolve: {
            // 자주 쓰이는 경로 POST라는 키워드로 낭비를 줄일 수 있다.
            alias: { 
                'POST': path.join(__dirname,'src/components/post')
            }
        }
    },

    transpileDependencies: [
      'vuetify'
    ]
}
