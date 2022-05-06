package com.project.mabarba.payload.response;



import java.io.Serializable;

public class RestResponse implements Serializable {

        private Object data;
        private String message;
        private ResponseStatus status;
        private int code;

        public RestResponse() {

        }

        public RestResponse(Object data) {
            this.data = data;
        }

        public RestResponse(String message, ResponseStatus status, int code) {
            this.message = message;
            this.status = status;
            this.code = code;
        }

        public RestResponse(Object data, String message, ResponseStatus status, int code) {
            this.data = data;
            this.message = message;
            this.status = status;
            this.code = code;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ResponseStatus getStatus() {
            return status;
        }

        public void setStatus(ResponseStatus status) {
            this.status = status;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "RestResponse{" +
                    "data=" + data +
                    ", message='" + message + '\'' +
                    ", status=" + status +
                    ", code=" + code +
                    '}';
        }

    }
