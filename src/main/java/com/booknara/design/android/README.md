# Android system design practice

## An approach to solve system design within 1 hour
1. stage 1: requirement gathering (like some major feature of Instagram)
2. stage 2: high level design of newsfeed, comment, draw a diagram to show how client is going to talk to server
3. stage 3: talked about major architecture pattern and which pattern I can use (my case I told I prefer mvvm)
4. stage 4: detail design:
    - how data will flow from view to server
    - model
    - database
    - cashing
    - parsing
    - what will be the purge mechanism of data
5. stage 5: limitation of android system how I am gonna address that in my design
6. limitation - storage, connectivity (wifi/ mobile data(3G/4G)), battery

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
    - explicit intent: Explicit Intents invoke the Activity class.


 
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
