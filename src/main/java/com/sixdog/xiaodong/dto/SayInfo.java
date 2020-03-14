package com.sixdog.xiaodong.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SayInfo {
	@Getter
	@Setter
	private String title;
	@Getter
	@Setter
	private String content;
}
