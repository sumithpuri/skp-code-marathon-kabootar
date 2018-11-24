package me.sumithpuri.github.kabootar.dwr;

import java.util.Collection;
import java.util.Set;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

import me.sumithpuri.github.kabootar.jms.KabootarChatAsyncSubject;

/**
 * MIT License
 *
 * Copyright (c) 2018-19,	Sumith Kumar Puri

 * GitHub URL 			https://github.com/sumithpuri
 * Blog Post URL		http://www.techilashots.com/2009/01/spring-dwr-ext-js-chat-application.html
 * Blog Short URL		https://goo.gl/k7uXqz
 * Package Prefix 		me.sumithpuri.github.kabootar
 * Project Codename		kabootar
 * Contact E-Mail		code@sumithpuri.me
 * Contact WhatsApp		+91 9591497974
 *
 *
 * Permission is hereby  granted,  free  of  charge, to  any person  obtaining a  copy of  this  software and associated 
 * documentation files (the "Software"), to deal in the  Software without  restriction, including without limitation the 
 * rights to use, copy, modify, merge, publish, distribute, sub-license and/or sell copies of the Software and to permit 
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in  all copies or substantial portions of the 
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS  OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES  OR  OTHER  LIABILITY, WHETHER IN AN ACTION  OF  CONTRACT, TORT OR 
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class KabootarChatDynamicController {

	public void sendKabootar(String kabootar) {
		WebContext webContext = WebContextFactory.get();
		String currentPage = webContext.getCurrentPage();
		
		Collection sessions = webContext.getScriptSessionsByPage(currentPage);
		Util utilAll = new Util(sessions);
		
		utilAll.addFunctionCall("broadcastKabootar", kabootar);
	}
	
	public void refreshUsers() {
		WebContext webContext = WebContextFactory.get();
		String currentPage = webContext.getCurrentPage();
		Collection sessions = webContext.getScriptSessionsByPage(currentPage);
		Util utilAll = new Util(sessions);		
		Set<String> userList = KabootarChatAsyncSubject.getInstance().getUsers();
		StringBuffer users = new StringBuffer();
		
		for(String userName: userList) {
			users.append(userName + " ");
		}
		
		String userStr = users.substring(0, users.length()-1);
		utilAll.addFunctionCall("broadcastUsers", userStr);
		
		// Ensuring that current Script Session is Updated
		// Util utilThis = new Util(webContext.getScriptSession());
		// utilThis.addFunctionCall("broadcastUsers", userStr);
	}
}
