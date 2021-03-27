## The Yummy App

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
This application was created to provide users with many different recipes with step-by-step instructions.

### App Evaluation
- **Category:** Photo & Video / Social
- **Mobile:** The app would be primarily developed for mobile. Functionality wouldn't be limited to mobile devices, however mobile version could potentially have more features.The mobile app will use camera and audio.
- **Story:**. Allow users to go to one place and get a recipe at any given time. 
- **Market:** Any user can use the app. Ability to find something to cook. 
- **Habit:** Users can use the app throughout the day many times. Users can explore endless amount of recipes to try. 
- **Scope:** The App  will start out just browsing recipes. When it’s time to  expand it would include favoriting your recipes to your account. 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

[X] User can create a new account
[X] User can login
[X] User can view photos
![Alt Text](http://g.recordit.co/eaeSPrJiGw.gif)
[X] User can scroll through recipes stories and clicking on stories takes them to the instruction

**Optional Nice-to-have Stories**

* User can see trending recipe
* User  can like a recipe
* User can see their profile page with their favorite recipes
* User can add a comment to recipes

### 2. Screen Archetypes

* Login Screen
   * User can login
* Registration Screen
   * User can create a new account
* Stream 
   * User can view a feed of photos
* Detail
   * User can see recipe information

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Sign-in
* Create an account
* Recipe Selctions

**Flow Navigation** (Screen to Screen)

* Forced Log-in -> Account creation if no log in is available
* Recipe Selection -> Jumps to Recipe
* Profile -> Text field to be modified.
* Settings -> Toggle settings

## Wireframes

<img src="https://github.com/CodePath-Group-Project-TTC/The-Yummy-App/blob/main/Wireframe.jpg" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
### Models
#### Post

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user post (default field) |
   | author        | Pointer to User| image author |
   | image         | File     | image that user posts |
   | caption       | String   | image caption by author |
   | createdAt     | DateTime | date when post is created (default field) |
   
### Networking
#### List of network requests by screen
   - Home Feed Screen
      - (Read/GET) Query all posts where user is author
         ```swift
         let query = PFQuery(className:"Post")
         query.whereKey("author", equalTo: currentUser)
         query.order(byDescending: "createdAt")
         query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
            if let error = error { 
               print(error.localizedDescription)
            } else if let posts = posts {
               print("Successfully retrieved \(posts.count) posts.")
           // TODO: Do something with posts...
            }
         }
         ```
   - Create Post Screen
      - (Create/POST) Create a new post object
   - Profile Screen
      - (Read/GET) Query logged in user object
      - (Update/PUT) Update user profile image
      
#### [OPTIONAL:] Existing API Endpoints



