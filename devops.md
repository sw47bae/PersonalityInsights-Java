# Describes how to create a DevOps Toolchain for this project
* Login in to your Bluemix account and make sure to set the region to US-South. As at 3 November 2016, The Toolchains service is currently available in the US-South region.
* From your Bluemix web console, select Services and then DevOps
* From the DevOps view, presss _Create a Toochain_
* You will see a list of pre-defined Toolchain templates. Feel free to explore these. When you are ready, select _Simple Cloud Foundry Toolchain_
* In the settings for creating the new Toolchain
  * give the Toolchain a name
* Click on the GitHub icon to configure the repository
  * In the _Repository type_, select _Fork_
  * In the _Source repository URL_ enter the URL for this repository. 'https://github.com/iwinoto/PersonalityInsights-Java.git'
  * Select _Enable Issues_ to use GitHub issues to create and manage issues for your project in GitHub.
* Click _Create_. The other tools can be configured later.
* You now have a set of tools that your project team can use to develop and continuously deploy your application.
* In the Toochain view, select the _Delivery Pipeline_ tool
  * You will see a default delivery pipeline which can be customised.
