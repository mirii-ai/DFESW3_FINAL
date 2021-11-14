# DFESW3_FINAL
<h1>Final project for QA Academy</h1>
<p></p>
<p></p>
<p><b>o	Why are we doing this?</b></p>
<p>I am making this project to test my knowledge and capabilities following a few weeks of Java and SpringBoot training.
I would like to create this project, a language revision app with CRUD functionality, to pursue a project type that 
I would be interested in as I myself love to learn languages and wish to see if I can begin to create something that I
would find useful. The app should allow users to upload words to a database, and call upon words randomly (or words
with priority) to revise a set at a time. 
<p></p>
<p><b>o	How I expected the challenge to go.</b></p>
<p>I wasn't sure how the project would go. Having only two weeks' of experience in Java, I felt that I perhaps wasn't the best
prepared to undertake such a project. However, it has been very insightful and I have enjoyed it a lot. There are some features I know I do not
have enough time to add at the time of writing this, but hopefully I will be able to add them in my own time.</p>
<p></p>
<p><b>o	What went well? / What didn't go as planned?</b></p>
<p>What went well:</p>
<p>I was able to create a basic functioning app! I have created the backend for a language revision app and none of the methods break when it runs.
All of the integration and Unit Tests work as well which is really good for me in terms of confidence and will to tackle projects in the future.</p>
<p></p>
<p>It has full CRUD functionality. The user can create/add a new entry to the database, they can update/change the entry itself or certain elements (eg, priority, memorised or even change the spelling of a word if it is incorrect), they can delete entries they no longer want, and they can also return lists of entries already in the database.</p>
<p></p>
<p>What didn't go so well:</p>
<p>When I get stuck, I hyperfocus on the issue so I may have lost a lot of time on areas when I could have moved on and worked on other functions
and gone back to the problem if I had time at the end. One big issue for me was returning only a select number of columns from the database- I spent around
six hours altogether trying to fix it, when in reality it doesn't remove any core functionality from the app so it wasn't a necessary feature.
I need to work on what to prioritise in the future.</p>
<p></p>
<p>I would also like to add more features in the future. Another one that stands out to me is allowing the user to delete items from a list where every item is 'memorised', allowing the user to pick items out of their database more efficently.</p>
<p></p>
<p><b>o	Possible improvements for future revisions of the project.</b></p>
<p>Adding the features I want to. One of the things I really want to work on is a method that returns a set number of results instead of everything. I did end up working a little bit on this in my spare time after the initial Firday deadline, however, I couldn't make it work and didn't have enough time to figure out a solution. I may work on this completely outside of QA but as it stands at the moment I don't have enough time/flexibility to work on it to the level it needs to be.
(If a user has time to only revise 10 items, they don't want the app to return everything they've inputted!)</p>
<p>Another couple of features I could add are combinations of ones that already exist. For example, creating much more specific searches such as searches
by category, priority and type. I have the basic functionality down, such as searches by category/priority and category/type, but there are many more
combinations I could put in to really enhance the search results given back to the user. To be a properly effective language app, there could be a potentially infinite combination of features the user could use to make their study more effective, but within the scope of a week I had to choose the ones that I thought would be most beneficial to the function of the application.</p>
<p></p>
<p><b>o	Screenshots showing your postman requests and the output from the API.</b></p>
<p></p>
<p>![image](https://user-images.githubusercontent.com/56605032/141503494-768900d3-81cd-465e-aa39-7561683d9b77.png)</p>
<p>  ![image](https://user-images.githubusercontent.com/56605032/141503855-14846c57-2455-4718-868c-567f2950c646.png)</p>
<p>RETRIEVE BY ID:</p>
<p>  ![image](https://user-images.githubusercontent.com/56605032/141504014-292c6980-baaa-4c45-992e-753a2ec0e002.png)</p>
<p>RETRIVE BY CATEGORY:</p>
 <p> ![image](https://user-images.githubusercontent.com/56605032/141504151-50b4081a-589e-4abf-b525-82fc3c34710f.png)</p>
<p>RETRIEVE BY TYPE [VERB in this example]:</p>
 <p> ![image](https://user-images.githubusercontent.com/56605032/141504232-ff0aae1f-e7a9-4f6d-8598-e2732622d40e.png)</p>
<p>RETRIEVE BY CATEGORY_TYPE:</p>
 <p> ![image](https://user-images.githubusercontent.com/56605032/141504384-3c342a9a-bf63-4453-beea-53131bfccfe0.png)</p>
<p>RETRIEVE BY PRIORITY [true in this example]:</p>
 <p> ![image](https://user-images.githubusercontent.com/56605032/141504463-7da139ac-2b48-4dfb-a3cd-8e55af4e74ce.png</p>
<p>RETRIEVE ONLY FOREIGN WORD + CATEGORY + TYPE:</p>
<p>  ![image](https://user-images.githubusercontent.com/56605032/141504592-67fafccc-94fa-49b2-8b81-12ba0cf6ab62.png)</p>
<p>RETRIEVE ALL:</p>
 <p> ![image](https://user-images.githubusercontent.com/56605032/141504681-5850fbc0-ffa3-4c4c-aef0-832c60b4149f.png)</p>
<p>SEARCH BY FOREIGN WORD:</p>
<p>  ![image](https://user-images.githubusercontent.com/56605032/141504792-4cb6826d-0981-4bda-bcbd-c6fac3340b8f.png)</p>
<p>SEARCH BY CATEGORY_PRIORITY:</p>
 <p> ![image](https://user-images.githubusercontent.com/56605032/141504855-ab028b92-959d-426d-b58f-c8af8129da5e.png)</p>
<p>CHANGE ENTRY AT ID 10: (If I had more time I would elaborate on this one. I have already created a 'delete word at [word entry]' instead of ID, so I would also like to one <p>day implement a 'change entry at [word entry]' as well.)</p>
<p>  ![image](https://user-images.githubusercontent.com/56605032/141504976-1c6641e1-3241-46cf-86e3-65f7197290ec.png)</p>
<p>FIND ID OF WORD BY WORD ENTRY: (Useful for other methods but figured it out very close to the end, haven't had much chance to use it yet.)</p>
 <p> ![image](https://user-images.githubusercontent.com/56605032/141505271-90f53a9b-c410-4b7d-b884-79e77f075c37.png)</p>
<p>DELETE ENTRY BY ID: (Will delete the entry 'seiji' in my runthrough)</p>
 <p> ![image](https://user-images.githubusercontent.com/56605032/141505378-04fa455e-e7ce-41ce-b89c-ab7cf2725e98.png)</p>
<p>DELETE ENTRY BY WORD: (Will delete the entry 'kankyou'from my database)</p>
 <p> ![image](https://user-images.githubusercontent.com/56605032/141505766-08e78411-42a2-45ca-8fbf-97564ada104f.png)</p>
<p>*Note: this does NOT work when there are duplicate entries of the same word in my database.</p>
<p></p>

<p><b>o	Screenshots of your database to prove that data is being persisted.</b></p>
<p>ADDED:</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507090-676cbfee-472d-455c-a4ec-c1e8b118c59b.png)</p>
<p>DELETED USING WORD ENTRY (kankyou):</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507242-491b0001-8ee8-4494-b139-d7a9f26361d5.png)</p>
<p>COMPLETELY CHANGED THE WORD AT ENTRY 1</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507473-d2e28fc3-888a-42c5-9c90-db0878127420.png)</p>
<p></p>

<p><b>o	Screenshot of your test results, including coverage report.</b></p>
<p>COVERAGE REPORT</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141503373-5a1f0707-0b2c-4a2f-b8c1-97366cfb4050.png)</p>
<p>Sunday:</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141687707-1c0f3c03-d4d5-4a27-92ee-46ceda31fb30.png)
</p>
<p>SCREENSHOT OF TESTS</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507744-54eed7bd-ad33-4873-95a9-b87a65dfddbd.png)</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507807-eb58f81d-142f-4001-89aa-08555ae71a26.png)
</p>
<p>There are, however, some issues with my code. Besides not having the full functionality that I had hoped at the beginning of the project, it runs reasonably well. HOWEVER, if there are duplicate entries of words in the database, some of the methods (and tests) do not run properly. The ID will always be unique as it is auto generated, but the word search function and other such methods fail when there is more than one entry of the same thing. It also causes problems when updating results too. Having the search by ID function is important in this respect because, although the 'search for id by word input' function will not work if there's more than one copy of a word in the database (how does it know what to choose?), there is still a possibility to remove the duplicate if you find its ID. This can be done through finding the ID by "retrieve All" in postman and finding the relevant word, then deleting by ID.</p>
<p>Another small issue I had when testing was making sure that the prod/test file was apporpriately referenced. Also ensuring that under 'application-prod' the 'spring.jpa.hibernate.ddl-auto:' part of the code was correctly set to either create or validate.</p>
<p>One final issue: My test didn't work properly at first becuase the name of my database was camel case. I didn't know that SQL does not like this and changed it to Language_Table (when I thought it was LanguageTable). This took a lot of time to sort out but the fix was very simple and thankfully the instructors helped me to figure out what the issue was!</p>
<p></p>
<p><b>o	Link to Jira Board - You must add Ed as collaborators on your Jira board.</b></p>
<p>https://ameliasommer.atlassian.net/jira/software/projects/DFS/boards/3/backlog</p>
<p>I have completed all my sprints, but thankfully the backlog can still be viewed with all the relevant tasks I wished to complete and what acceptance criteria I gave them. </p>
<p>![image](https://user-images.githubusercontent.com/56605032/141687128-35ad335e-2e3b-4270-9228-e01aee9292cd.png)
</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141687156-2db9d0f8-3c6b-4f09-80fa-dc8681b1f99d.png)
</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141687174-9027042f-df78-466c-a13c-6519042d798e.png)
</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141687188-4465d2d0-414b-4886-a9d1-0917094ffc65.png)
</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141687239-db230980-cb12-4b70-aad7-f4044e13bb91.png)
</p>
<p></p>
<p></p>![image](https://user-images.githubusercontent.com/56605032/141687267-f87bbe66-6960-4979-9a3f-1bd40576e233.png)
<p></p>
<p>These are not screenshots of every item in my Jira board- but they are a collection of a few examples from the board in case for some reason it cannot be accessed. I have added Ed as an administrator to the project so hopefully this will not happen! I used a collection of user stories and tasks to define where I wanted my project to go and what I wanted to complete next. The user stories helped me to think about functionality and what sort of code I would have to type to fulfil it, whereas the tasks helped me to remember important steps of the app building process.</p>
<p></p>
<p><b>Custom queries:</b></p>
<p>![image](https://user-images.githubusercontent.com/56605032/141687757-f2433fc4-899a-4405-bc12-c2214c9c055c.png)
</p>
<p>Unfortunately I also didn't have time to implement custom exceptions in my code. I had initial issues getting my tests to work as per an issue described above that took a long time to figure out how to solve- which meant time was taken away from potentially working on other things such as this.</p>
<p>However, I am overall very happy with where my project is after this week. Having only learned Java for two weeks, I feel that I have learned a lot and come a long way in terms of coding knowledge and application of this knowledge. Again, while I couldn't implement everything I wanted to, I feel that at the end of the day this is OK as this is my first project in Java and issues that have 'easy fixes' but take a long time to be solved are to be expected for me at this stage. I can take this newfound knowledge and apply it to projects later, so that's fine by me as far as I am concerned!</p>
<p></p>
<p>Amelia Sommer</p>
