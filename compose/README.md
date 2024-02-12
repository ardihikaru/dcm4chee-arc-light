# info
* run compose:
  ```shell
  docker-compose --env-file .env -p dcm4chee up
  ```
* video: https://www.youtube.com/watch?v=brKD19nY3Mc&list=PLz7FsrtxQxg39lBB-pR-iftglO_Gfo4Co&index=2
* run min: https://github.com/dcm4che/dcm4chee-arc-light/wiki/Run-minimum-set-of-archive-services-on-a-single-host
* run on docker: https://github.com/dcm4che/dcm4chee-arc-light/wiki/Running-on-Docker
* Installation finished, [can open](https://github.com/dcm4che/dcm4chee-arc-light/wiki/Running-on-Docker):
  * Wildfly Administration Console: http://localhost:9990, login with Username: root, Password: changeit.
    * [to make it works](https://groups.google.com/g/dcm4che/c/JLwZSkhPXUo)
      * add login info:
        ```shell
        ...
        WILDFLY_ADMIN_USER: admin
        WILDFLY_ADMIN_PASSWORD: admin
        ...
        ```
      * 
  * DICOM QIDO-RS Base URL: http://localhost:8080/dcm4chee-arc/aets/DCM4CHEE/rs
  * DICOM STOW-RS Base URL: http://localhost:8080/dcm4chee-arc/aets/DCM4CHEE/rs
  * DICOM WADO-RS Base URL: http://localhost:8080/dcm4chee-arc/aets/DCM4CHEE/rs
  * DICOM WADO-URI:         http://localhost:8080/dcm4chee-arc/aets/DCM4CHEE/wado
  * IHE XDS-I Retrieve Imaging Document Set: http://localhost:8080/dcm4chee-arc/xdsi/ImagingDocumentSource
* Continue [the video](https://www.youtube.com/watch?v=brKD19nY3Mc&list=PLz7FsrtxQxg39lBB-pR-iftglO_Gfo4Co&index=2)
  * first, install [DVTK]()https://www.dvtk.org/
  * create login (FREE)
  * Download *Storage SCU Emulator* (got Version 5.2.1)
* Next, install OHIF
  * [video](https://www.youtube.com/watch?v=gWzrF7WnDM8&list=PLz7FsrtxQxg39lBB-pR-iftglO_Gfo4Co&index=3)
  * [link tutorial](https://openintegrator.com/how-to-install-ohif-web-based-dicom-viewer-in-docker-and-connect-to-dcm4chee-vna/)
  * docker pull ohif/viewer
  * docker run -p 3000:80 ohif/viewer:latest
    ```shell
    PS. Noticed that on 16/11/2021 the latest has some issues so you can use instead this version:
    docker pull ohif/viewer:v2.11.8.7749
    ```
  * currently using: docker pull ohif/viewer:v4.12.51.21579
  * docker run -p 3000:80 ohif/viewer:v4.12.51.21579
  * open on browser: http://localhost:3000/
* 
