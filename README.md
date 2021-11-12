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
<p>o	How I expected the challenge to go.</p>
<p>I wasn't sure how the project would go. Having only two weeks' of experience in Java, I felt that I perhaps wasn't the best
prepared to undertake such a project. However, it has been very insightful and I have enjoyed it a lot. There are some features I know I do not
have enough time to add at the time of writing this, but hopefully I will be able to add them in my own time.</p>
<p></p>
<p>o	What went well? / What didn't go as planned?</p>
<p>What went well:</p>
<p>I was able to create a basic functioning app! I have created the backend for a language revision app and none of the methods break when it runs.
All of the integration and Unit Tests work as well which is really good for me in terms of confidence and will to tackle projects in the future.</p>
<p>What didn't go so well:</p>
<p>When I get stuck, I hyperfocus on the issue so I may have lost a lot of time on areas when I could have moved on and worked on other functions
and gone back to the problem if I had time at the end. One big issue for me was returning only a select number of columns from the database- I spent around
six hours altogether trying to fix it, when in reality it doesn't remove any core functionality from the app so it wasn't a necessary feature.
I need to work on what to prioritise in the future.</p>
<p></p>
<p>o	Possible improvements for future revisions of the project.</p>
<p>Adding the features I want to. One of the things I really want to work on is a method that returns a set number of results instead of everything.
(If a user has time to only revise 10 items, they don't want the app to return everything they've inputted!)
Another couple of features I could add are combinations of ones that already exist. For example, creating much more specific searches such as searches
by category, priority and type. I have the basic functionality down, such as searches by category/priority and category/type, but there are many more
combinations I could put in to really enhance the search results given back to the user.</p>
<p></p>
<p>o	Screenshots showing your postman requests and the output from the API.</p>
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

<p>o	Screenshots of your database to prove that data is being persisted.</p>
<p>ADDED:</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507090-676cbfee-472d-455c-a4ec-c1e8b118c59b.png)</p>
<p>DELETED USING WORD ENTRY (kankyou):</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507242-491b0001-8ee8-4494-b139-d7a9f26361d5.png)</p>
<p>COMPLETELY CHANGED THE WORD AT ENTRY 1</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507473-d2e28fc3-888a-42c5-9c90-db0878127420.png)</p>
<p></p>

<p>o	Screenshot of your test results, including coverage report.</p>
<p>COVERAGE REPORT</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141503373-5a1f0707-0b2c-4a2f-b8c1-97366cfb4050.png)</p>
<p>SCREENSHOT OF TESTS</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507744-54eed7bd-ad33-4873-95a9-b87a65dfddbd.png)</p>
<p>![image](https://user-images.githubusercontent.com/56605032/141507807-eb58f81d-142f-4001-89aa-08555ae71a26.png)
</p>
<p></p>
<p><b>o	Link to Jira Board - You must add Ed as collaborators on your Jira board.</b></p>
<p>https://ameliasommer.atlassian.net/jira/software/projects/DFS/boards/3/backlog</p>
<p></p>
