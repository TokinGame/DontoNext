package hu.tokin.game.dontonext.MyBaseClasses.Bluetooth;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyStage;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 17..
 */

abstract public class BluetoothStage extends MyStage {




    public float getElapsedTime() {
        return elapsedTime;
    }

    private float elapsedTime = 0;

    public iBluetooth getBluetoothManager() {
        return BluetoothSingleton.getInstance().bluetoothManager;
    }

    public BluetoothStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    public void startBluetoothListening(){
        getBluetoothManager().enableBluetooth();
        getBluetoothManager().enableDiscoveribility();
        getBluetoothManager().startServer();
    }

    public void startBluetoothDiscovering(){
        getBluetoothManager().enableBluetooth();
        getBluetoothManager().discoverDevices();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime+=delta;
    }

    public ArrayList<String> getDiscoveredDevicesName(){
        ArrayList<String> strings = new ArrayList<String>();
        while (!getBluetoothManager().isFirst()) {
            getBluetoothManager().switchToPrevDevice();
        }
        boolean next = true;
        while (!getBluetoothManager().isLast() || next) {
            if (getBluetoothManager().isLast()) {
                next = false;
            }
            strings.add(getBluetoothManager().getDevice());
            getBluetoothManager().switchToNextDevice();
        }
        return strings;
    }

    public void startConnectingToDevice(int discoveredDeviceNum){
        while (!getBluetoothManager().isFirst()) {
            getBluetoothManager().switchToPrevDevice();
        }
        for (int i = 0; i < discoveredDeviceNum; i++) {
            getBluetoothManager().switchToNextDevice();
        }
        getBluetoothManager().connectToServer();
    }
}
