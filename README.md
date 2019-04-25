# android-coding-challenge

Please use this project and this GitHub repository for your work. Commit just like you would in a real project. Also, feel free to use any other GitHub features you might want to.

We have included some of the libraries that we use in our every day work here at moovel but you're in **no way** required to use them. Feel free to add and use anything you want to achieve the task. We've also added one Unit and one Integration Test so you don't need to worry about the setup.

## Task

#### User List

When opening the app, show a list of all Kotlin developers.

* Use the GitHub API to load the users
  * You can either use the [v3](https://developer.github.com/v3/search/#search-users) or [v4](https://developer.github.com/v4/object/user/) version of their API
* Load maximum 10 users at once
* Only show Kotlin users
* Each displayed user item should contain at least:
  * username
  * avatar
  * (bonus): registration date
  * (bonus): order by username

All of the network related code should be implemented in the existing network module.

#### User Detail

When clicking on a user item, show a detail screen.

* A mandatory detail is the email address as well as the number of followers
* When clicking on the email address, the default email app, installed on the device should open up
* Feel free to add any other details you want

## Contact

If you have any further question please do not hesitate to ask [Julia Rosenblau](mailto:julia.rosenblau@moovel.com).
