# non-working-jersey-ejb-injection
a non working demo project, presenting a failed attempt at @EJB injection into a Jackson service endpoint / Stateless bean

The problem is that the injected EJB is null.

The project is eclipse importable.


To build it from eclipse, 

1. create a maven build config, with goal: clean package

2. edit src/main/resources/config.properties and set the path to your server's deployments' folder

3. run the build config created at step 1


To call the webservice, use:

GET localhost:8080/rest/myapp/document/test

GET localhost:8080/rest/myapp/user/test

If injection would work, you should see some dummy data added after the call of the 2 endpoints in the server log. 
Since it doesn't work, you just get a response OK from the server, with the message 'injection failed'.
