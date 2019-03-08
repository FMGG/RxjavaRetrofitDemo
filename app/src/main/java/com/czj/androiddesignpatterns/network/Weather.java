package com.czj.androiddesignpatterns.network;

public class Weather extends BaseResponse{


    /**
     * data : {"reportTime":"2019-03-08 15:13:43","humidity":"87%","windDirection":"东","address":"广东省 深圳市","windPower":"≤3级","cityCode":"440300","weather":"阴","temp":"16℃"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * reportTime : 2019-03-08 15:13:43
         * humidity : 87%
         * windDirection : 东
         * address : 广东省 深圳市
         * windPower : ≤3级
         * cityCode : 440300
         * weather : 阴
         * temp : 16℃
         */

        private String reportTime;
        private String humidity;
        private String windDirection;
        private String address;
        private String windPower;
        private String cityCode;
        private String weather;
        private String temp;

        public String getReportTime() {
            return reportTime;
        }

        public void setReportTime(String reportTime) {
            this.reportTime = reportTime;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getWindDirection() {
            return windDirection;
        }

        public void setWindDirection(String windDirection) {
            this.windDirection = windDirection;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getWindPower() {
            return windPower;
        }

        public void setWindPower(String windPower) {
            this.windPower = windPower;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }
    }
}
