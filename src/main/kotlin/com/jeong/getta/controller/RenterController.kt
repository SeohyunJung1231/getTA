package com.jeong.getta.controller

import com.jeong.getta.domain.ReservationInfo
import com.jeong.getta.service.AircraftRentalService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "대여자 API", description = "항공기 대여자와 관련된 데모 API 입니다.")
@RestController
@RequestMapping("/renters")
class RenterController(
    private val service: AircraftRentalService
) {
    @Operation(summary = "예약한 항공기 조회", description = "대여자가 예약한 항공기 목록을 조회합니다.")
    @GetMapping("/{renterId}/reservations")
    fun getReservation(
        @PathVariable renterId: Long
    ): List<ReservationInfo> {
        return service.getBy(renterId)
    }
}