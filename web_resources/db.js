// <script src="https://sdk.amazonaws.com/js/aws-sdk-2.7.16.min.js"></script>
var docClient;

$('document').ready(function(){
    
    AWS.config.update({
        region: "ap-southeast-2",
        endpoint: 'dynamodb.ap-southeast-2.amazonaws.com',
        // accessKeyId default can be used while using the downloadable version of DynamoDB. 
        // For security reasons, do not store AWS Credentials in your files. Use Amazon Cognito instead.
        accessKeyId: "AKIAJZGVSR4TC7QQNSEA",
        // secretAccessKey default can be used while using the downloadable version of DynamoDB. 
        // For security reasons, do not store AWS Credentials in your files. Use Amazon Cognito instead.
        secretAccessKey: "jHIdgWe05PuuRscEyWhAnUvZFvkZ9oQcDQ04HH/5"
  });

    docClient = new AWS.DynamoDB.DocumentClient();
   

    $('.testbutton').click(function(event){

        event.preventDefault();
        var username = $('.name').val();
        console.log(username);
        createUser(username);
    })

});



// Creates a 12digit UUID1 with in order to have a unique ID for each user
function createUniqueId() {
    var uuid = "", i, random;
    for (i = 0; i < 12; i++) {
      random = Math.random() * 16 | 0;
  
      uuid += (i == 12 ? 4 : (i == 16 ? (random & 3 | 8) : random)).toString(16);
    }
    return uuid;
}

// Checks whether the ID exists in the db
function checkIDExists(_uuid){

    var params = {
        TableName :"Test_Table",
        Key:{
            "UserId": _uuid,
        }
    };

    docClient.get(params, function (err, data) {
        if (err){ console.log("id1: ", err, err.stack); // an error occurred
              return false;
          } else { console.log(data); // successful response         
              return true;
          }
    });   

  
}
// Checks whether the Username is valid in db (exists or meets criteria)
function checkUsernameExists(_Username, callback){

    var params = {
        TableName :"Test_Table",
        IndexName: "Username-index",

        ProjectionExpression: "UserId, Username",
        KeyConditionExpression: "Username = :userval",
        ExpressionAttributeValues: {":userval": _Username}
        
    };
 
    var outcome = true;
    docClient.query(params,function(err, data){
       
        if (err){ console.log("nobuddy",err); outcome=true;} 
        else { console.log("yebuddy",data);
                    if(data.Count > 0){
                        outcome=true;
                    }
                    else {outcome=false}}    
                    
    });
    console.log("docClient Query: ",outcome)
    callback(outcome);
    return outcome;
    
}

// Adds the user to the db
function createUser(_username){

    if(checkUsernameExists(_username)){
        console.log("account exists - choose another username")
    }
    else{
        console.log("account doesn't exist - proceed with user creation")
        var uuid=createUniqueId();
        while(checkIDExists(uuid)){
            uuid=createUniqueId(); 
            console.log("re-creating uuid")       
        }
        
        console.log("creating params")
        var params = {
            TableName :"Test_Table",
            Item:{
                "UserId": uuid,
                "Username": _username,
                "Password": "Test123",
            }
        };  

        console.log("ready to put into DB")

           
        /*
        docClient.put(params, function(err, data) {
        if (err) {
            console.log("item not created");
        } else {
            console.log("item is created");
        }
        });
        */       
    }
}

