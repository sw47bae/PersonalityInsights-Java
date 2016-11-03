# Describes how to create a DevOps Toolchain for this project
## Create a DevOps Toolchain on Bluemix Public for this project
* Login in to your Bluemix account and make sure to set the region to US-South. As at 3 November 2016, The Toolchains service is currently available in the US-South region.
* From your Bluemix web console, select Services and then DevOps
* From the DevOps view, presss _Create a Toochain_
* You will see a list of pre-defined Toolchain templates. Feel free to explore these. When you are ready, select _Simple Cloud Foundry Toolchain_
* In the settings for creating the new Toolchain
  * give the Toolchain a name
* Click on the GitHub icon to configure the repository
  * In the _Repository type_, select _Fork_
  * In the _Source repository URL_ enter the URL for this repository. `https://github.com/iwinoto/PersonalityInsights-Java.git`
  * Select _Enable Issues_ to use GitHub issues to create and manage issues for your project in GitHub.
* Click _Create_. The other tools can be configured later.
* You now have a set of tools that your project team can use to develop and continuously deploy your application.
* In the Toolchain view, select the _Delivery Pipeline_ tool
  * You will see a default delivery pipeline which can be customised.
  * The pipeline contains 2 stages, Build and Deploy. We need to change the Deploy stage to make sure the service is created.
  * Click on the gear on the top right of the Deploy box and select _Configure Stage_
  * In the _Deploy Script_ at the bottom of the configuration screen, add the following line right after `#!/bin/bash`
  
        ```
        #!/bin/bash
        cf create-service personality_insights tiered PersonalityInsights-personality_insights
        ```

    Click _SAVE_
* Test the Delivery Pipeline by pressing the _Run Stage_ button on the top right of the Build stage box. This will checkout the code from the repository, perform a build and then trigger the Deploy stage which will create the service and push the applciation to Bluemix.

## Make a change to the code to trigger a delivery.
You can change the code using either your favourite code editing tool after cloning the repository to your local environment. Alternatively, if you don't have an editing tool, you can use the Web IDE which is configured with the toolchain. These instructions use the Web IDE.
* If you are in the Delivery Pipeline view, press the _Toolchain_ link on the top left of the browser page. This will navigate to the Toolchain overview, showing all the tools configured in this toolchain.
* Under the _Code_ section, you will see the _Eclise Orion Web IDE_ tool. Click on this tool to open the Web IDE. This has the look and feel of a regular IDE but it runs in the browser.

We are going to modify the code to render a kill button on the page. When the user presses the kill button, the application instance will be terminated.

* In the left project navigation pane, open the `WebContent` folder and select the `index.jsp` file.
* In the `index.jsp` file, scroll down to find the line `<!--Uncomment to add instance kill -->`. It is located at approximately line 47.
* To the `<div>` below the comment contains the kill button and is commented out. Remove the comment delimiters so the kill button will render. The Web IDE is normall set to auto save, so you should not have to press `File->Save`. To check if auto save is turned on, click on the _spanner_ icon on the top right above the code editing pane. Make sure the _Auto Save_ check box is ticked.
* In the editor menu, select `View -> Open Related -> Git Repository`
* In the right hand panel you will see a summary of the difference between the Web IDE workspace and the git repository. Above the file and code view, is a text box. Enter a relevant commit message, such as `Adding instance kill button`.
* Press the _Commit_ button on the top right. This commits the changes ready to be pushed.
* On the left side, press the _Push_ button to check in the changes to the GitHub repository.
* Navigate back to the Toolchain view. There is a bug in the UI at the moment which results in not being able to navigate back to the Toolchain from the Web IDE. You need to navigate to the Bluemix console home page and then open the menu and select _Services_ and _DevOps_, then selec the Toolchain.
* Open the _Delivery Pipeline_ view. You will see that the _Build_ stage has completed and the _Deploy_ stage is probably in progress.
When the _Deploy_ stage completes, open the applciation home page and you will see a _Kill_ button on the top right of the page.
* You can open the _Build_ stage log to see the build logs and also trace back to the code change which caused the build and deploy.

# Git Issues
**Work In Progress**

