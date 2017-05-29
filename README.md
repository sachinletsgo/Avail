## Welcome to Avail

By this library, any one can write any log into log file. whuch may be used to track the response and behaviour of application. 

### Markdown

Avail is easy to use. Below is step bt step process how to use it

```markdown
### Step 1.  Add it in your root build.gradle at the end of repositories:

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
### Step 2. Add the dependency
dependencies {
	        compile 'com.github.sachinletsgo.Avail:filecreate:0.0.2'
	}
### Step 3. Add the folling code in the Application class (onCreate() method)
 This will be initlize single time 
                AddLog.init("/SD/DCIM/",getApplicationContext(),"0.0.1");
                In the above code we have to pass 3 paramter
                - Path for file creation.
                - Context of application.
                - App version.
                
 You may add follwoing paramter also (optional) 
 - To add the desired date format
                AddLog.setDateFormat("yyyy-MM-dd hh:mm:ss");
 - Add device name 
                AddLog.setDeviceName("Moto e");
 - File should be recycled
                AddLog.setIsFileRecycled(true);
 - Maximum file size  
                AddLog.setMaxFileSize(1024*5);


### Step 4. Add the folling code in the file to lock in the file
               AddLog.appendLog("Who are you", true);




### Support or Contact

Having trouble with Pages? You may contact to me on Sachintech.tyagi@gmail.com.
