package cordova.plugin.RootApkInstaller;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;

public class RootApkInstaller extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("install")) {
            String fileLocation = args.getString(0);
			String apkName = args.getString(1);

            this.installApk(fileLocation, apkName, callbackContext);
            return true;
        }
        return false;
    }

    private void installApk(String fileLocation, String apkName,CallbackContext callbackContext) {
        if (fileLocation != null && fileLocation.length() > 0 && apkName != null && apkName.length() > 0 ) {
            callbackContext.success("Executing installation");
            Context context = this.cordova.getActivity().getApplicationContext();

            String apkDir = fileLocation + apkName;
            String activityDir =  context.getPackageName() +"/"+  context.getPackageName() +".MainActivity";

            try {
                final String command = "chmod 777 " + fileLocation+ "* ;pm install -r "+ apkDir +";am start -n " + activityDir;
                Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", command});
                proc.waitFor();

            }catch (Exception ex) {
                callbackContext.error(ex.toString());
            }

        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
