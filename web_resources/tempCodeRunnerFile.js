async function checkUsernameExists(_Username){

//     var params = {
//         TableName :"Test_Table",
//         IndexName: "Username-index",

//         ProjectionExpression: "UserId, Username",
//         KeyConditionExpression: "Username = :userval",
//         ExpressionAttributeValues: {":userval": _Username}
        
//     };

//     var outcome=false;
//     var x =  await docClient.query(params, function(err, data){
//         console.log("Can this work or not my god??")
//         if (err){ console.log("nobuddy");} 
//         else { console.log("yebuddy",data); outcome=true; 
//             if(data.Count==0){
//                 outcome=true;}
//             }       
//     });
//     console.log("outcome: ", outcome)
    
//     return outcome
// }