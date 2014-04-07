var CommonUtil = {
    isEmpty : function (value) {
        var result = (typeof value == 'undefined') || value === null;

        if (typeof value == "string") {
            result = value.trim().length == 0;
        }
        return result;
    },
};