# LabSec Challenge

### 1. Used Software
- IDE Eclipse Photon Release (4.8.0)
- Tomcat 9 as Server
- jdk version 1.8.0_171

### 2. Instruction to run
- Donwload Tomcat and Unzip tomcat zip file.
Example:
    > C:\apache-tomcat-9.0.0.M22 

To test de code:
- Set up the Apache Server to use it from Eclipse: take a look at these tutos [tomcat1](https://github.com/OneBusAway/onebusaway/wiki/Setting-Up-a-Tomcat-Server-in-Eclipse),
[tomcat2](https://crunchify.com/step-by-step-guide-to-setup-and-install-apache-tomcat-server-in-eclipse-development-environment-ide/).
- Clone/download this repository.
- Open Eclipse and import as _Maven Project_ the 2 projects in the repository folder.
- The project _**FrontFileUploader**_ is the frontend that displays the HTML to choose a file in the file system and upload to the rest endpoint.
- The project _**LabSecFileUploaderService**_ is the backend (REST service) responsible to compute the _SHA-256_ hash of submited files and return a string encoded using _base64 encoding_ of this hash.
- Run _maven install_ in the 2 projects (Select a project in the tree explorer, rigth click got to **"Run As >> Maven Install"**). In the eclipse console shoul appear a  message showing that the build process was executed succesfully.

    ```sh
    [INFO] ----------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ----------------------------------------
    [INFO] Total time: 3.614 s
    [INFO] Finished at: 2018-07-11T23:25:47-03:00
    [INFO] ----------------------------------------
    ```
 - Deploy the to projects to the Server
- Start the server and navigate to **http://localhost:8080/FrontFileUploader/** choose a file and upload it.
