package com.dtech.web.template.spring.events;

import org.springframework.context.ApplicationEvent;

public class FileEvent extends ApplicationEvent {

	private static final long serialVersionUID = -2295594563921146287L;

	public FileEvent(Object source) {
		super(source);
	}
	
	@Override
	public String toString() {
		return "FileEvent: my event invoked";
	}
}
