This is a little project that is able to get the current network's gateway IP on Termux, done as a demonstration. This is necessary because Android 14+ restricts access to /proc/net, making it impossible to obtain the current gateway IP through conventional means.

To build on device, you'll need to setup sdkmanager and set your ANDROID\_HOME environment variable, and add `android.aapt2FromMavenOverride=/data/data/com.termux/files/usr/bin/aapt2` to your ~/.gradle/gradle.properties.

Before executing `./command/run`, you'll need to run `gradle extractDexDebug` or `gradle build` (see above about building on device). It's not actually necessary to extract the dex file to run it, you can just point the script to the apk instead (by replacing `-cp $DEX_FILE` with `-cp [apk file here]` in the final line of the script, and ensuring that the apk has it's mode set to 0400).
