var argscheck = require('cordova/argscheck'),
    exec = require('cordova/exec');

function RootApkInstaller() {
    console.log("RootApkInstaller.js : is created");
}		
	
RootApkInstaller.prototype.install = function( fileLocation, apkName, success, error) {
    exec(success, error, "RootApkInstaller", "install", [fileLocation,apkName]);
};

RootApkInstaller.install = function () {
    if (!window.plugins) {
        window.plugins = {};
    }
    window.plugins.rootApkInstaller = new RootApkInstaller();
    return window.plugins.rootApkInstaller;
};

cordova.addConstructor(RootApkInstaller.install);