<h1 align="center">
  <br>
  <a href="http://www.amitmerchant.com/electron-markdownify"><img src="https://i.imgur.com/tUjygyP.png" alt="Rocket League Map Loader" width="200"></a>
  <br>
  Rocket League Map Loader
  <br>
</h1>

<h5 align="center">A cross-platform application for importing, managing, and loading custom maps into Rocket
League.</h5>



<div align="center">
    <img src="https://i.imgur.com/LElU6Ns.png" />
</div>

---

## Contents

- [Prerequisites](#prerequisites)
- [Build](#build)
- [Download](#download)
- [Instructions](#instructions)
- [FAQ](#faq)
- [License](#license)

## Prerequisites

You will need Java 18 (or above) to build and run Rocket League Map Loader

- JavaFX is not required as it's bundled into the FAT jar

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
Loader [here](https://github.com/Deluxepter/rlmaploader/releases)

## Instructions

1. [Download](#download) or build the application
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
Map must be in a zip file
```

5. Load a map by clicking on the map
6. Open **Rocket League** and select **Underpass** as your free-play map
7. Enjoy!

## FAQ

> "How do I revert the underpass map back to normal?"

You can revert the map back to normal in ```Map > Reset```

> "Where are the maps stored?"

The maps are stored in the directory you selected for your Rocket League installation

## License

This project is licensed under the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html) - see
the LICENSE.md file for details