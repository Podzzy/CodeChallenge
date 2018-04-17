# CodeChallenge

Problem: Data from a given URL needs to be fetched and parsed. Java objects need to be created for the name, city, state, and end time stored in the JSON. These objects need to be displayed in a recycle view along with the icon image.

Solution: Using AsyncTask, a http GET connection is made to the URL and the data is retrieved. This data was first parsed into strings and then turned into a JSON object. A recycle view was created to hold the designated objects, but some trouble with the context and time constraints (approaching 3 hours) ended the challenge before the items could be displayed.

If I were to do this challenge again, I would go about the data retrieval differently and eliminate the context issues. I would also include the ability to get the image from the given URL and take more time making sure the recycle view adapter is working probperly. Additionally, I would improve the look of the UI. 

