package io.karn.instagram.core

internal object Endpoints {
    private const val API_URL = "https://i.instagram.com/api/v1"
    const val GRAPH_API_URL = "https://instagram.com/graphql/query"

    const val LOG_ATTRIBUTION = "https://b.i.instagram.com/api/v1/attribution/log_attribution/"
    const val CSRF_TOKEN = "$API_URL/si/fetch_headers/"
    const val LOGIN = "$API_URL/accounts/login/"
    const val LOGIN_APPROVAL = "$API_URL/accounts/two_factor_login"
    const val CHALLENGE_PATH = "$API_URL%s"
    const val LOGOUT = "$API_URL/accounts/logout/"
    const val ACCOUNT_INFO = "$API_URL/users/%s/info/"
    const val ACCOUNT_BLOCK_LIST = "$API_URL/users/blocked_list/"
    const val ACCOUNT_FEED = "$API_URL/feed/user/%s/"
    const val FOLLOWERS = "$API_URL/friendships/%s/followers/"
    const val FOLLOWING = "$API_URL/friendships/%s/following/"
    const val FOLLOW = "$API_URL/friendships/create/%s/"
    const val UNFOLLOW = "$API_URL/friendships/destroy/%s/"

    const val SEARCH = "$API_URL/users/search/"

    const val STORIES = "$API_URL/feed/user/%s/story/"

    const val MEDIA_LIKES = "$API_URL/media/%s/likers/"
    const val MEDIA_COMMENTS = "$API_URL/media/%s/comments/"

    const val DIRECT_MESSAGES = "$API_URL/direct_v2/inbox/"

    const val COLLECTIONS_LIST = "$API_URL/collections/list/"

    const val FOLLOWERS_HASH = "56066f031e6239f35a904ac20c9f37d9"
    const val FOLLOWING_HASH = "c56ee0ae1f89cdbd1c89e2bc6b8f3d18"
}
