# SI Camunda Delivery Service

Simple Camunda BPMN Delivery Service.

Docker can be used to start the Camunda Platform:
 
* docker run -d --name camunda -p 8080:8080 camunda/camunda-bpm-platform:latest

Login with username demo and password demo.

Upload delivery.bpmn through Camunda Modeler located in resources folder in the project.

Start the supplied Java application to subscribe to Camunda through REST.

Start a process in through the Camunda Platform by selecting the process "Place delivery order". Type an address. It must be a Danish address, otherwise the application will reject to request.

The task will now appear in the taskboard for human interaction. It can be either approved or rejected by the user. If rejected the process will end. If confirmed, the Java application will now run the payment process.


