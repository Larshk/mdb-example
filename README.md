# mdb-example

An example Gradle project to build a Java EE EAR with a single EJB module containing a single MDB class.

This project contains a root project that builds an EAR. There is one sub-project to build an EJB JAR.

To build the project run

    gradle build

or

    gradle ear

The resultant EAR will be generated in the build/libs directory.

The EAR file can be deployed to a Java EE Application Server. The MDB consumes messages from a queue called
"TestQueue".