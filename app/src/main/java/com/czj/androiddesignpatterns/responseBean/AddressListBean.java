package com.czj.androiddesignpatterns.responseBean;

import com.czj.androiddesignpatterns.network.BaseResponse;

import java.util.List;

public class AddressListBean extends BaseResponse{


    /**
     * code : 1
     * msg : 数据返回成功
     * data : [{"code":"110000","name":"北京市","pchilds":[{"code":"110100","name":"市辖区","cchilds":[{"code":"110101","name":"东城区"},{"code":"110102","name":"西城区"},{"code":"110105","name":"朝阳区"},{"code":"110106","name":"丰台区"},{"code":"110107","name":"石景山区"},{"code":"110108","name":"海淀区"},{"code":"110109","name":"门头沟区"},{"code":"110111","name":"房山区"},{"code":"110112","name":"通州区"},{"code":"110113","name":"顺义区"},{"code":"110114","name":"昌平区"},{"code":"110115","name":"大兴区"},{"code":"110116","name":"怀柔区"},{"code":"110117","name":"平谷区"},{"code":"110118","name":"密云区"},{"code":"110119","name":"延庆区"}]}]}]
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code : 110000
         * name : 北京市
         * pchilds : [{"code":"110100","name":"市辖区","cchilds":[{"code":"110101","name":"东城区"},{"code":"110102","name":"西城区"},{"code":"110105","name":"朝阳区"},{"code":"110106","name":"丰台区"},{"code":"110107","name":"石景山区"},{"code":"110108","name":"海淀区"},{"code":"110109","name":"门头沟区"},{"code":"110111","name":"房山区"},{"code":"110112","name":"通州区"},{"code":"110113","name":"顺义区"},{"code":"110114","name":"昌平区"},{"code":"110115","name":"大兴区"},{"code":"110116","name":"怀柔区"},{"code":"110117","name":"平谷区"},{"code":"110118","name":"密云区"},{"code":"110119","name":"延庆区"}]}]
         */

        private String code;
        private String name;
        private List<PchildsBean> pchilds;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<PchildsBean> getPchilds() {
            return pchilds;
        }

        public void setPchilds(List<PchildsBean> pchilds) {
            this.pchilds = pchilds;
        }

        public static class PchildsBean {
            /**
             * code : 110100
             * name : 市辖区
             * cchilds : [{"code":"110101","name":"东城区"},{"code":"110102","name":"西城区"},{"code":"110105","name":"朝阳区"},{"code":"110106","name":"丰台区"},{"code":"110107","name":"石景山区"},{"code":"110108","name":"海淀区"},{"code":"110109","name":"门头沟区"},{"code":"110111","name":"房山区"},{"code":"110112","name":"通州区"},{"code":"110113","name":"顺义区"},{"code":"110114","name":"昌平区"},{"code":"110115","name":"大兴区"},{"code":"110116","name":"怀柔区"},{"code":"110117","name":"平谷区"},{"code":"110118","name":"密云区"},{"code":"110119","name":"延庆区"}]
             */

            private String code;
            private String name;
            private List<CchildsBean> cchilds;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<CchildsBean> getCchilds() {
                return cchilds;
            }

            public void setCchilds(List<CchildsBean> cchilds) {
                this.cchilds = cchilds;
            }

            public static class CchildsBean {
                /**
                 * code : 110101
                 * name : 东城区
                 */

                private String code;
                private String name;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
