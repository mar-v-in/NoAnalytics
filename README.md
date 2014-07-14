NoAnalytics
===========

Clone of GoogleAnalytics for Android that does nothing - use as replacement in open source apps to make them free.

Usage
-----

###To build CyanogenMod
Once android_external_google is removed from CyanogenMod, it is no longer possible to build the Settings app. Luckily you can add NoAnalytics to your build system to fix this:

	<project path="external/NoAnalytics" name="mar-v-in/NoAnalytics" revision="master" />


###General Purpose
Replace "libGoogleAnalytics.jar" (or whatever it's named) with the binary "noAnalytics-0.*.jar" (or a self-compiled version) and recompile the Application.

###License
> Copyright 2012-2014 μg Project Team

> Licensed under the Apache License, Version 2.0 (the "License");
> you may not use this file except in compliance with the License.
> You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

> Unless required by applicable law or agreed to in writing, software 
> distributed under the License is distributed on an "AS IS" BASIS,
> WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
> See the License for the specific language governing permissions and
> limitations under the License.
