# Apk Installer (Only for rooted devices)

## Description
This is a cordova plugin to install apk file into rooted device and execute the app.

## Install 

cordova plugin add https://github.com/tyduztck/cordova-plugin-rootApkInstaller

## Usage 
You can access this plugin by js object `window.plugins.rootApkInstaller.install`.

window.plugins.rootApkInstaller.install([file directory],[apk file name],success callback,error callback);

Example: 

document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
	window.plugins.rootApkInstaller.install(cordova.file.dataDirectory.replace('file://',''),"app.apk",
		function(){},
		function(error){
			console.error(error);
		}
	);
}

## Notice
Only for Android rooted devices.

