package io.karn.instagram

import androidx.test.core.app.ApplicationProvider
import io.karn.instagram.api.AuthenticationBootstrapAPI
import io.karn.instagram.core.SyntheticResponse
import org.json.JSONObject
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@RunWith(RobolectricTestRunner::class)
class AuthenticationBootstrapTest {

    private val instanceID = Random(System.currentTimeMillis()).toString()

    @Test
    fun testAuthentication() {

        Instagram.init(ApplicationProvider.getApplicationContext())
        Instagram.getInstance().initializeSession(instanceID, "")

        assertEquals("", Instagram.getInstance().session.midToken)
        assertEquals("", Instagram.getInstance().session.csrfToken)

        val headerData = JSONObject()
                .put("mobile_subno_usage", "ig_select_app")
                .put("device_id", Instagram.getInstance().session.uuid)

        val res = AuthenticationBootstrapAPI.getHeaders(Instagram.getInstance().session, headerData)

        assertEquals("""{"remaining_ttl_seconds":43200,"ttl":2,"status":"ok"}""", res.jsonObject.toString())
    }

    @Test
    fun testAuthenticationBootstrap() {

        Instagram.init(ApplicationProvider.getApplicationContext())
        Instagram.getInstance().initializeSession(instanceID, "")

        assertEquals("", Instagram.getInstance().session.midToken)
        assertEquals("", Instagram.getInstance().session.csrfToken)

        val res = Instagram.getInstance().authentication.bootstrap()

        assert(res is SyntheticResponse.Bootstrap.Success)

        assertNotEquals("", Instagram.getInstance().session.midToken)
        assertNotEquals("", Instagram.getInstance().session.csrfToken)
        assertNotEquals(0, Instagram.getInstance().session.publicKeyId)
        assertNotEquals("", Instagram.getInstance().session.publicKey)

        assertNotEquals("", (res as SyntheticResponse.Bootstrap.Success).data.optString("token"))
    }
}
