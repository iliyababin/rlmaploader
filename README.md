# Rocket League Map Loader

A cross-platform application for importing, managing, and loading custom maps into Rocket League.

<p>
    <img src="https://i.imgur.com/LElU6Ns.png" width="600"/>
</p>

---

## Contents

- [Prerequisites](#prerequisites)
- [Build](#build)
- [Download](#download)
- [Instructions](#instructions)
- [FAQ](#faq)

## Prerequisites

You will need Java 18 (or above) to build and run Rocket League Map Loader.

- JavaFX is not required as it's bundled into the FAT jar.

## Build

Clone the project

```
git clone https://github.com/deluxepter/rlmaploader

cd rlmaploader
```

Build the project

```
mvn clean package
```

Run the jar

```
cd target

java -jar rlmaploader-1.0.jar
```

## Download

You can download the latest version of Rocket League Map
Loader [here.](https://github.com/Deluxepter/rlmaploader/releases)

## Instructions

1. Download or build the application
2. Run ```rlmaploader-1.0.jar```
3. Select your Rocket League installation folder in ```Help > Settings```

```
Default installation folders:

Windows:
C:\Program Files\Epic Games\rocketleague\

MacOS:
Custom

Linux:
Custom

WARNING: /Documents/My Games/Rocket League/
IS NOT THE CORRECT INSTALLATION DIRECTORY
```

4. Import a map in ```Map > Import```

```
Map must be stored in a zip file
```

5. Load a map by clicking on the map
6. Open **Rocket League** and select **Underpass** as your free-play map, enjoy!
7. Revert underpass back to normal in ```Map > Reset```

## FAQ

