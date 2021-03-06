package com.haleywang.putty.service.action.strategy;

import com.haleywang.putty.dto.Action;
import com.haleywang.putty.service.action.ActionStrategy;
import com.haleywang.putty.view.SpringRemoteView;

/**
 * @author haley
 */
public class LayoutActionStrategy implements ActionStrategy {
    @Override
    public boolean execute(Action action) {

        SpringRemoteView.getInstance().changeAndSaveTermIndex(action.getAction());
        focusTerm();

        return true;
    }
}
