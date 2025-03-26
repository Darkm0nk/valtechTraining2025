package com.valtech.training.leave.config;

import feign.Logger;

public class OneLineLogger extends Logger {

	@Override
	protected void log(String configKey, String format, Object... args) {
		String msg = String.format(configKey + " - " + format , args);
		System.out.println(msg);
	}

}
