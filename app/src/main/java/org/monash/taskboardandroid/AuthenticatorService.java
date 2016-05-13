package org.monash.taskboardandroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Blake on 11/05/2016.
 */
public class AuthenticatorService extends Service {
    private TaskboardAuthenticator mAuthenticator;

    @Override
    public void onCreate(){
        mAuthenticator = new TaskboardAuthenticator(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
