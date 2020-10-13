# Android system design practice

## An approach to solve system design within 45 minutes
1. stage 1: Functional requirement gathering (like some major feature of Instagram) - 5 minutes
    - Outline a few simple features
    - Ask the interviewer to add something to features
2. stage 2: Non-functional requirement gathering - 2 minutes
    - Memory consumption
    - Battery consumption
    - Bandwidth consumption (Batch job instead of every time network request)
    - Resilience (how to recover a failure)
    - Persistence
    - Scalability (include Device Support as well)
    - Security/Privacy
3. stage 3: HLD(high level design) of newsfeed, comment, draw a diagram to show how client is going to talk to server - 10 minutes
4. stage 4: Data Model/API Design - 5 minutes
    - how data will flow from view to server
    - model
    - database
    - cashing
    - parsing
    - what will be the purge mechanism of data
5. stage 5: Resilience (fallback solution) for edge/failure case - 5 minutes 
6. stage 6: Non-Functional requirement - 5 minutes
    - Security
    - Scalability
    - limitation - storage, connectivity (wifi/ mobile data(3G/4G)), battery
7. stage 7: Further discussion

## Android Basic Knowledge
1. Android core components
    - Activity: Activities are the part of the mobile app which the user can see and interact with.
    - Intent: It can be used when a user navigates from one activity to another activity or starts Android service 
    - Service : Service is an Android component that runs in the background and acts independently. It does not provide any user interface.
    - Content Provider
    - Fragment
    - Broadcast Receiver
2. Activity Lifecycle
    - onCreate(), onStart(), onRestart(), onResume(), onPause(), onStop(), and onDestroy()
3. Android Intent 
    - Implicit intent: Implicit Intent calls the system components
    - Explicit intent: Explicit Intents invoke the Activity class.

## Android Best practices
1. Minimum SDK level
There are two API level settings available:
- minSdkVersion — The minimum version of the Android platform on which the app will run, specified by the platform's API level identifier.
If the minSdkVersion value is greater than the system version, the system prevents the installation of the app.
- targetSdkVersion — Specifies the API level on which the app is designed to run. In some cases, this allows the app to use manifest elements or behaviors defined in the target API level, rather than being restricted to using only those defined for the minimum API level.
![Android Min API version stat](https://github.com/booknara/playground/blob/master/src/main/java/com/booknara/design/android/API_version.png)
2. Supported devices
- Screen size(like tablet)
- Screen density(hdpi ~ xxhdpi: more than 80%)
- Android Auto, Android TV 

3. Battery consumption
- Make your apps Lazy First. Making your app Lazy First means looking for ways to reduce and optimize operations that are particularly battery-intensive.
    - Reduce: Are there redundant operations your app can cut out? For example, can it cache downloaded data instead of repeatedly waking up the radio to re-download the data?
    - Defer: Does an app need to perform an action right away? For example, can it wait until the device is charging before it backs data up to the cloud?
    - Coalesce: Can work be batched, instead of putting the device into an active state many times? For example, is it really necessary for several dozen apps to each turn on the radio at separate times to send their messages? Can the messages instead be transmitted during a single awakening of the radio?
- Take advantage of platform features that can help manage your app's battery consumption.
    - Doze and App Standby (Starting from Android 6.0 or higher)
        - Doze reduces battery consumption by deferring background CPU and network activity for apps when the device is unused for long periods of time. While the device is in Doze, apps' access to certain battery-intensive resources is deferred until maintenance windows. During this maintenance window, the system runs all pending syncs, jobs, and alarms, and lets apps access the network. As soon as the user wakes the device by moving it, turning on the screen, or connecting a charger, the system exits Doze and all apps return to normal activity.
        - App Standby defers background network activity for apps with which the user has not recently interacted.
        - Utilize Downstream messaging like FCM
        - If you need to set alarms that fire while in Doze, use setAndAllowWhileIdle() or setExactAndAllowWhileIdle().
        - FCM is optimized to work with Doze and App Standby idle modes by means of high-priority FCM messages
    - App Standby Bucket
    - Background restrictions (https://developer.android.com/topic/performance/background-optimization#bg-restrict)
    - Power management restrictions (https://developer.android.com/topic/performance/power/power-details)
    - Testing and troubleshooting  
- Use tools that can help you identify battery-draining culprits.

4. Guide of background work and limit
https://developer.android.com/guide/background
- Background optimization (JobScheduler, WorkManager)

5. Location

6. Security

7. Mobile data consumption
- Waiting for wi-fi to send a high quality video/photo

Question
1. Live location sharing with server
2. Google Calendar
3. Building a Messenger application
4. Design a ride sharing service for three building

License
-------
MIT License

Copyright (c) 2020 Daehee Han

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
