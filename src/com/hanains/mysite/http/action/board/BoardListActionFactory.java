package com.hanains.mysite.http.action.board;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;
import com.hanains.mysite.http.action.board.IndexAction;

public class BoardListActionFactory extends ActionFactory {
	@Override
	public Action getAction(String actionName){
		Action action = null;
		
		if("delete".equals(actionName)){
		//	action = new DeleteAction();
		}else if("insert".equals(actionName)){//완료
		//	action = new InsertAction();
		}else if("del".equals(actionName)){
		//	action = new DelAction();
		}else{
			//index(default action)
			action = new IndexAction();
		}
		return action;
	}
}