package me.sumithpuri.github.kabootar.jms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import me.sumithpuri.github.kabootar.dto.Kabootar;
import me.sumithpuri.github.kabootar.dto.User;

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
public class KabootarChatAsyncSubject {

	private static KabootarChatAsyncSubject subject = new KabootarChatAsyncSubject();
	
	private Queue<Kabootar> kabootars = new LinkedList<Kabootar>();
	private List<User> users = new ArrayList<User>();
	
	private KabootarChatAsyncSubject() {
	}
	
	public static KabootarChatAsyncSubject getInstance() {
		return subject;
	}
	
	public synchronized void registerUser(User user) {
		System.out.println("Added User " + user.getUserName() +  " to " + this);
		users.add(user);
	}
	
	public void removeUser(Integer userId) {
		users.remove(userId);
	}
	
	public synchronized Set<String> getUsers() {
		
		Set<String> userNames = new HashSet<String>();

		for(User user: users) {
			userNames.add(user.getUserName());
		}
		
		return userNames;
	}
	
	public void addKabootar(Kabootar kabootar) {
		kabootars.add(kabootar);
	}
	
	public static void invokeNotification(Object object) {
		// Notify Individual Clients via KabootarChatAsyncProcessor
		// Remove, if it is a Kabootar
	}
}
