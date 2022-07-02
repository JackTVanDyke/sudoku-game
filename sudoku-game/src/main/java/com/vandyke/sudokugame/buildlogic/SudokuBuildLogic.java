package com.vandyke.sudokugame.buildlogic;

import com.vandyke.sudokugame.computationlogic.GameLogic;
import com.vandyke.sudokugame.datapersistence.LocalStorageImpl;
import com.vandyke.sudokugame.problemdomain.IStorage;
import com.vandyke.sudokugame.problemdomain.SudokuGame;
import com.vandyke.sudokugame.userinterface.IUserInterfaceContract;
import com.vandyke.sudokugame.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();
        try {
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }
        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
