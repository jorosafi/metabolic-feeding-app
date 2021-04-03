# Organic Acidemia Baby Bottle Feeding Tracker


### Background
My wife and I had a baby boy in August 2020 in Prince Rupert BC, just two weeks before I started the BCS program. 
On his third night at the hospital, the nurses noticed he was breathing abnormally fast. They immediately took him for 
further examination and prepared us to be airlifted to Prince George, which had the nearest NICU. 

This started a two-week stay at the hospital in Prince George and later the BC Children's Hospital in Vancouver, 
where the doctors found that Santiago, our baby, has a rare metabolic disease called Isovaleric Acidemia (IVA). He is missing a
digestive enzyme, which prevents him from properly digesting protein. If he has more protein than what his body can
digest, he can go into a metabolic crisis that can lead to neurological damage and developmental delays. 
But having too little food can be equally dangerous as the human body breaks down protein in the muscle mass 
as a store of energy when there is no more food to digest.

The biggest challenge we've had over the past six months has been to bottle-feed him. He has a very strict diet
that is constantly being tweaked by nutritionists at the BC Children's hospital to account for his nutritional needs
and the amount of protein his body can safely digest. We measure all of his formula ingredients to the nearest gram,
and have to keep track of how much he is eating and when. 

### The App

While there are a myriad of feeding apps for adults, children and babies, there is no decent app that meets the needs 
for babies suffering this disease as it is extremely rare. 

This is why I want to build an app that can help us track his nutritional intake and keep better data that can be 
shared with his medical team. This app will be used by me and my wife and, if I find it works for us, I can offer to 
build a publicly available version for other IVA families. 

While I have bigger ambitions for this app, for the scope of this project, I will limit it to the following features:
- A user will be able to add a recipe for the daily formula, which is used to create a feeding schedule for the day.
- At the end of a feed, the caregivers can log the amount left over by the child. The app will add up how much of 
the feed the baby missed throughout the day. 
- The caregivers can track the supply of medical formula ingredients left and when new orders have to be made. 
Given the importance of this formula, caregivers are encouraged to always keep a month's supply of the medical formula 
in case of emergency or shipment delays. The caregivers can input the formula recipe and the supply of ingredients, 
and the app will estimate how many days worth of ingredients the caregivers have left. 

### User Stories
These are the use cases I envision for this app:

- As a user, I want to be able to input a formula recipe
- As a user, I want the app to divide up the daily feeds into a daily schedule
- As a user, I want to be able to mark a feed as complete and input how much of the feed the baby left behind
- As a user, I want to see daily totals of how much the baby ate
- As a user, I want to be able to input the supply of formula ingredients I have, along with the daily recipe and
know how long the existing ingredient supply will last. 
- As a user, I want to be able to save the daily schedule and the log feeds, so I can quit and return to the program at 
    different times.
- As a user, I want to keep a record of all the feeding logs to gather statistics about the feed to answer questions
    like, how much was left at the end of the day? What is the average leftover in a given week or month?
- As a user, I want the ingredient supply to be saved in a file where amounts are deducted each day as new daily
    schedules are created and amounts can be added. 

### Looking ahead

After I am done with CPSC 210, I would like to add extra features to this app as the baby grows and our needs evolve. 
Eventually, I would like to take this code base and use it for an android app that includes a cloud database so each 
caregiver can input and view information from their phones or any connected device.

As he starts eating solid foods, it's also important to track the nutritional information of solid foods, 
so in the long run I would like to find a database of nutritional information for foods that  I can connect to the app. 

###Phase 4: Task 2
I used a type hierarchy to build my GUI. I built all the screens in the app using the BasicScreen abstract class,
which acts as a basic template for the screens. The HomeScreen and LoadScreen directly extend the 
BasicScreen. The UtilityScreen is an abstract class that extends the BasicScreen and acts as the template for 
FeedingScheduleScreen, RecipeScreen, LogScreen and SupplyScreen.

The BasicScreen holds the fields and basic styling for the frame, the page header, page title, page body, and buttons.
It also holds the feedingApp field, which is used to communicate back and forth with the FeedingApp class. All the 
subclasses override different methods to manipulate these fields to customize each page as needed. For example, most 
classes override the setPageTitle() and setBody() methods to customize these page elements. 

###Phase 4: Task 3
[UML Class Diagram](images/UML-design.png "UML Class Diagram")

My app design consists of four distinct parts divided across 20 classes. The structure can be divided into:
- The FeedingApp class, which is the central class that holds all the information for the app, has the console UI,
and connects the GUI, the persistence and the model packages.
- The model package holds all the basic functionality of the app. It has the classes for Recipe, Feed, Log, 
LogList, DailySchedule, and IngredientSupply which define the different components and functionality for the app. 
- The persistence package contains the Notebook, JSonWriter, JsonReader and the Writeable interface. This package 
handles the persistence mechanism for the app. 
- Finally, the graphics package has all the classes that build the GUI for the app. It consists of two abstract classes
that act as templates and 6 classes that implement the different screens the user can interact with. 

If I had more time to work on this project I would make two changes to my class structure: 
1. Currently, the Recipe and IngredientSupply classes in the model package extend the Writeable interface to help
parse the Json file into information that can be used by those classes and vice versa. I would like to break that 
relationship and handle all the parsing in the Notebook class. This way, Notebook handles all the persistence 
functionality. 
2. The Recipe and IngredientSupply classes have a lot of duplicate code. I would like to extract some of that code 
into an abstract class for those classes to reduce the amount of duplication. When I originally wrote the classes, I 
didn't realize there would be so much overlap between them, so I did not bother creating a hierarchy for those classes, 
but in hindsight it would make for better code.  