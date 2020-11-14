package pages;

import org.apache.log4j.Logger;

import javax.xml.xpath.XPath;

public class BookingHeaders {
    private static final Logger LOGGER = Logger.getLogger(BookingHeaders.class);
    public static final String LOGO_ID = "logo_no_globe_new_logo";
    public static final String CHOOSE_CURRENCY_XPATH = "//*[@data-id='currency_selector']";
    public static final String CHOOSE_LANGUAGE_XPATH = "//*[@data-id='language_selector']";
    public static final String PROFILE_NOTIFICATION_XPATH = "//*[@class='bk-icon -sprite-profile_notification bui__profile_notification']";
    public static final String PROFILE_QUESTIONS_XPATH = "//*[@class='bk-icon -streamline-question_mark_circle']";
    public static final String ADD_PROPERTY_XPATH = "//*[@class='sign_in_wrapper sign_in_wrapper-add-property']";
    public static final String AVATAR_XPATH = "//*[@class='user_avatar user_avatar--circle user_avatar--normalised user_avatar--initial ge-no-yellow-img_border ']";
    public static final String USER_BLOCK_XPATH = "//*[@class='user_name_block']";

}
