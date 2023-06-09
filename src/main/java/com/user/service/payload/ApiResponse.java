package com.user.service.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(builderClassName = "builder", toBuilder = true)
public class ApiResponse {

	private String message;
	private boolean success;
	private HttpStatus status;

	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", success=" + success + ", status=" + status + "]";
	}

	 public static Builder builder() {
	        return new Builder();
	    }

	    public static class Builder {
	        private String message;
	        private boolean success;
	        private HttpStatus status;

	        private Builder() {
	        }

	        public Builder message(String message) {
	            this.message = message;
	            return this;
	        }

	        public Builder success(boolean success) {
	            this.success = success;
	            return this;
	        }

	        public Builder status(HttpStatus status) {
	            this.status = status;
	            return this;
	        }

	        public ApiResponse build() {
	            return new ApiResponse();
	        }

		
	    }

}
