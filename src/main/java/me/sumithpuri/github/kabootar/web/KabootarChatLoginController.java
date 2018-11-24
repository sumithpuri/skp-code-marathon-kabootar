package me.sumithpuri.github.kabootar.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import me.sumithpuri.github.kabootar.dto.User;
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
public class KabootarChatLoginController extends AbstractCommandController {

	public KabootarChatLoginController() {

		// Form Backing Object
		setCommandClass(me.sumithpuri.github.kabootar.dto.User.class);
		setCommandName("User");
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
		 						  HttpServletResponse response, 
		 						  Object login, 
		 						  BindException exception)
			throws Exception {
		
		// Register User
		User user = (User) login;
		KabootarChatAsyncSubject.getInstance().registerUser(user);
		return new ModelAndView("kabootar_chat_main","userName", user.getUserName());
	}
}
