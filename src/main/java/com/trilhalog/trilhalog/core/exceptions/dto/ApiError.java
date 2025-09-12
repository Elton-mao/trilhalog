package com.trilhalog.trilhalog.core.exceptions.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;



public record ApiError(
		@JsonFormat(pattern = "dd-mm-yy HH:mm:ss")
		LocalDateTime timestamp,
		Integer code,
		String status,
		List<String> erros
		) {
}
