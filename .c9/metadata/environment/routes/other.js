{"filter":false,"title":"other.js","tooltip":"/routes/other.js","undoManager":{"mark":22,"position":22,"stack":[[{"start":{"row":7,"column":21},"end":{"row":7,"column":22},"action":"insert","lines":[" "],"id":2}],[{"start":{"row":18,"column":6},"end":{"row":19,"column":0},"action":"insert","lines":["",""],"id":3}],[{"start":{"row":19,"column":0},"end":{"row":20,"column":0},"action":"insert","lines":["",""],"id":4}],[{"start":{"row":20,"column":0},"end":{"row":38,"column":6},"action":"insert","lines":["// router.get('/getAllUsers', function(request, response){","//     client.search({","//       index: 'tenner',","//       type: 'users'","//       /*body: {","//         query: {","//           match: {","//             body:  ''","//           }","//         }","//       }*/","//     }).then(function (responseBody) {","//         var data = responseBody.hits.hits;","//         return response.send(data);","//     }, function (err) {","//         console.log(err.message);","//         return response.send({'Error' : 'At /getAllUsers ' + err.message});","//     });","// });"],"id":5}],[{"start":{"row":20,"column":16},"end":{"row":20,"column":27},"action":"remove","lines":["getAllUsers"],"id":6},{"start":{"row":20,"column":16},"end":{"row":20,"column":17},"action":"insert","lines":["g"]}],[{"start":{"row":20,"column":17},"end":{"row":20,"column":18},"action":"insert","lines":["e"],"id":7}],[{"start":{"row":20,"column":18},"end":{"row":20,"column":19},"action":"insert","lines":["t"],"id":8}],[{"start":{"row":20,"column":19},"end":{"row":20,"column":20},"action":"insert","lines":["A"],"id":9}],[{"start":{"row":20,"column":20},"end":{"row":20,"column":21},"action":"insert","lines":["l"],"id":10}],[{"start":{"row":20,"column":21},"end":{"row":20,"column":22},"action":"insert","lines":["l"],"id":11}],[{"start":{"row":20,"column":22},"end":{"row":20,"column":23},"action":"insert","lines":["T"],"id":12}],[{"start":{"row":20,"column":23},"end":{"row":20,"column":24},"action":"insert","lines":["a"],"id":13}],[{"start":{"row":20,"column":24},"end":{"row":20,"column":25},"action":"insert","lines":["s"],"id":14}],[{"start":{"row":20,"column":25},"end":{"row":20,"column":26},"action":"insert","lines":["k"],"id":15}],[{"start":{"row":20,"column":26},"end":{"row":20,"column":27},"action":"insert","lines":["s"],"id":16}],[{"start":{"row":23,"column":16},"end":{"row":23,"column":21},"action":"remove","lines":["users"],"id":17},{"start":{"row":23,"column":16},"end":{"row":23,"column":17},"action":"insert","lines":["t"]}],[{"start":{"row":23,"column":17},"end":{"row":23,"column":18},"action":"insert","lines":["a"],"id":18}],[{"start":{"row":23,"column":18},"end":{"row":23,"column":19},"action":"insert","lines":["s"],"id":19}],[{"start":{"row":23,"column":19},"end":{"row":23,"column":20},"action":"insert","lines":["k"],"id":20}],[{"start":{"row":23,"column":20},"end":{"row":23,"column":21},"action":"insert","lines":["s"],"id":21}],[{"start":{"row":38,"column":6},"end":{"row":39,"column":0},"action":"insert","lines":["",""],"id":23}],[{"start":{"row":39,"column":0},"end":{"row":40,"column":0},"action":"insert","lines":["",""],"id":24}],[{"start":{"row":40,"column":0},"end":{"row":73,"column":6},"action":"insert","lines":["// router.post('/signInUser', function(request, response){","//     var user = request.body.user;","    ","//     if(typeof(user) != 'undefined'){","//         var queryString = 'email:' + user;","//         console.log(queryString);","        ","//         client.search({","//           index: 'tenner',","//           type: 'users',","//           q : queryString","//         }).then(function (responseBody) {","//             var data = responseBody.hits.hits;","//             console.log(data)","//             for(var dataObj in data){","//                 if (data.hasOwnProperty(dataObj)) {","//                     if(user == data[dataObj]._source.email){","//                         console.log('User Exists!');","//                         return response.send({'Success' : 'At /signInUser Log In!'});","//                     }","//                 }","//             }","//             return response.send({'Error' : 'At /signInUser No User Found!'});","            ","//         }, function (err) {","//             if(err){","//                 console.log(err.message);","//                 return response.send({'Error' : 'At /signInUser' + err.message});","//             }","//         });","//     } else {","//         return response.send({'Error' : 'At /signInUser No User Email!'});","//     }","// });"],"id":25}]]},"ace":{"folds":[],"scrolltop":664,"scrollleft":0,"selection":{"start":{"row":43,"column":0},"end":{"row":72,"column":8},"isBackwards":false},"options":{"guessTabSize":true,"useWrapMode":false,"wrapToView":true},"firstLineState":{"row":104,"mode":"ace/mode/javascript"}},"timestamp":1522955867249,"hash":"0f2c82802e9fe6483a5bd57eae0d40fe9353fa8a"}