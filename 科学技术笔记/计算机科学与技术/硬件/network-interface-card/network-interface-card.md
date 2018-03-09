# 网卡信息

~# ethtool -S eth0

```
NIC statistics:
     rx_packets: 514912887478
     tx_packets: 459844075392
     rx_bytes: 312164450204030
     tx_bytes: 135742711738556
     rx_pkts_nic: 514913553697
     tx_pkts_nic: 459844200842
     rx_bytes_nic: 314224148414349
     tx_bytes_nic: 137594905353510
     lsc_int: 3
     tx_busy: 0
     non_eop_descs: 411523
     rx_errors: 0
     tx_errors: 0
     rx_dropped: 0
     tx_dropped: 0
     multicast: 0
     broadcast: 221329
     rx_no_buffer_count: 0
     collisions: 0
     rx_over_errors: 0
     rx_crc_errors: 0
     rx_frame_errors: 0
     hw_rsc_aggregated: 1039080
     hw_rsc_flushed: 498661
     fdir_match: 490432032343
     fdir_miss: 25454854023
     fdir_overflow: 2669939
     rx_fifo_errors: 0
     rx_missed_errors: 0
     tx_aborted_errors: 0
     tx_carrier_errors: 0
     tx_fifo_errors: 0
     tx_heartbeat_errors: 0
     tx_timeout_count: 0
     tx_restart_queue: 0
     rx_long_length_errors: 0
     rx_short_length_errors: 0
     tx_flow_control_xon: 0
     rx_flow_control_xon: 0
     tx_flow_control_xoff: 0
     rx_flow_control_xoff: 0
     rx_csum_offload_errors: 0
     alloc_rx_page_failed: 0
     alloc_rx_buff_failed: 0
     rx_no_dma_resources: 236
     os2bmc_rx_by_bmc: 0
     os2bmc_tx_by_bmc: 0
     os2bmc_tx_by_host: 0
     os2bmc_rx_by_host: 0
     fcoe_bad_fccrc: 0
     rx_fcoe_dropped: 0
     rx_fcoe_packets: 0
     rx_fcoe_dwords: 0
     fcoe_noddp: 0
     fcoe_noddp_ext_buff: 0
     tx_fcoe_packets: 0
     tx_fcoe_dwords: 0
     tx_queue_0_packets: 8002744148
     tx_queue_0_bytes: 3707681776786
     tx_queue_0_bp_napi_yield: 0
     tx_queue_0_bp_misses: 0
     tx_queue_0_bp_cleaned: 0
     tx_queue_1_packets: 57503592849
     tx_queue_1_bytes: 9851124564684
     tx_queue_1_bp_napi_yield: 0
     tx_queue_1_bp_misses: 0
     tx_queue_1_bp_cleaned: 0
     tx_queue_2_packets: 7332466662
     tx_queue_2_bytes: 3205954362028
     tx_queue_2_bp_napi_yield: 0
     tx_queue_2_bp_misses: 0
     tx_queue_2_bp_cleaned: 0
     tx_queue_3_packets: 22235476399
     tx_queue_3_bytes: 6508432944496
     tx_queue_3_bp_napi_yield: 0
     tx_queue_3_bp_misses: 0
     tx_queue_3_bp_cleaned: 0
     tx_queue_4_packets: 7241846387
     tx_queue_4_bytes: 3157446889687
     tx_queue_4_bp_napi_yield: 0
     tx_queue_4_bp_misses: 0
     tx_queue_4_bp_cleaned: 0
     tx_queue_5_packets: 22826764709
     tx_queue_5_bytes: 6648664313594
     tx_queue_5_bp_napi_yield: 0
     tx_queue_5_bp_misses: 0
     tx_queue_5_bp_cleaned: 0
     tx_queue_6_packets: 7172813911
     tx_queue_6_bytes: 3126894088027
     tx_queue_6_bp_napi_yield: 0
     tx_queue_6_bp_misses: 0
     tx_queue_6_bp_cleaned: 0
     tx_queue_7_packets: 23453127088
     tx_queue_7_bytes: 6785065508577
     tx_queue_7_bp_napi_yield: 0
     tx_queue_7_bp_misses: 0
     tx_queue_7_bp_cleaned: 0
     tx_queue_8_packets: 7110414154
     tx_queue_8_bytes: 3101133823776
     tx_queue_8_bp_napi_yield: 0
     tx_queue_8_bp_misses: 0
     tx_queue_8_bp_cleaned: 0
     tx_queue_9_packets: 24075901343
     tx_queue_9_bytes: 6934533468537
     tx_queue_9_bp_napi_yield: 0
     tx_queue_9_bp_misses: 0
     tx_queue_9_bp_cleaned: 0
     tx_queue_10_packets: 7058404998
     tx_queue_10_bytes: 3080812868305
     tx_queue_10_bp_napi_yield: 0
     tx_queue_10_bp_misses: 0
     tx_queue_10_bp_cleaned: 0
     tx_queue_11_packets: 24982853224
     tx_queue_11_bytes: 7155370368443
     tx_queue_11_bp_napi_yield: 0
     tx_queue_11_bp_misses: 0
     tx_queue_11_bp_cleaned: 0
     tx_queue_12_packets: 7004779722
     tx_queue_12_bytes: 3059103575549
     tx_queue_12_bp_napi_yield: 0
     tx_queue_12_bp_misses: 0
     tx_queue_12_bp_cleaned: 0
     tx_queue_13_packets: 27076109026
     tx_queue_13_bytes: 7720825977545
     tx_queue_13_bp_napi_yield: 0
     tx_queue_13_bp_misses: 0
     tx_queue_13_bp_cleaned: 0
     tx_queue_14_packets: 6949158651
     tx_queue_14_bytes: 3037112544261
     tx_queue_14_bp_napi_yield: 0
     tx_queue_14_bp_misses: 0
     tx_queue_14_bp_cleaned: 0
     tx_queue_15_packets: 31716500043
     tx_queue_15_bytes: 9101176358304
     tx_queue_15_bp_napi_yield: 0
     tx_queue_15_bp_misses: 0
     tx_queue_15_bp_cleaned: 0
     tx_queue_16_packets: 551857766
     tx_queue_16_bytes: 247178737589
     tx_queue_16_bp_napi_yield: 0
     tx_queue_16_bp_misses: 0
     tx_queue_16_bp_cleaned: 0
     tx_queue_17_packets: 20292637687
     tx_queue_17_bytes: 5914792227111
     tx_queue_17_bp_napi_yield: 0
     tx_queue_17_bp_misses: 0
     tx_queue_17_bp_cleaned: 0
     tx_queue_18_packets: 543204304
     tx_queue_18_bytes: 243199673566
     tx_queue_18_bp_napi_yield: 0
     tx_queue_18_bp_misses: 0
     tx_queue_18_bp_cleaned: 0
     tx_queue_19_packets: 18686681103
     tx_queue_19_bytes: 5447207052667
     tx_queue_19_bp_napi_yield: 0
     tx_queue_19_bp_misses: 0
     tx_queue_19_bp_cleaned: 0
     tx_queue_20_packets: 540232984
     tx_queue_20_bytes: 242345607266
     tx_queue_20_bp_napi_yield: 0
     tx_queue_20_bp_misses: 0
     tx_queue_20_bp_cleaned: 0
     tx_queue_21_packets: 19057148491
     tx_queue_21_bytes: 5553335836799
     tx_queue_21_bp_napi_yield: 0
     tx_queue_21_bp_misses: 0
     tx_queue_21_bp_cleaned: 0
     tx_queue_22_packets: 538393203
     tx_queue_22_bytes: 241271541280
     tx_queue_22_bp_napi_yield: 0
     tx_queue_22_bp_misses: 0
     tx_queue_22_bp_cleaned: 0
     tx_queue_23_packets: 19674315623
     tx_queue_23_bytes: 5719067615401
     tx_queue_23_bp_napi_yield: 0
     tx_queue_23_bp_misses: 0
     tx_queue_23_bp_cleaned: 0
     tx_queue_24_packets: 539692537
     tx_queue_24_bytes: 241982692185
     tx_queue_24_bp_napi_yield: 0
     tx_queue_24_bp_misses: 0
     tx_queue_24_bp_cleaned: 0
     tx_queue_25_packets: 20257954705
     tx_queue_25_bytes: 5882818248116
     tx_queue_25_bp_napi_yield: 0
     tx_queue_25_bp_misses: 0
     tx_queue_25_bp_cleaned: 0
     tx_queue_26_packets: 538729913
     tx_queue_26_bytes: 241954187767
     tx_queue_26_bp_napi_yield: 0
     tx_queue_26_bp_misses: 0
     tx_queue_26_bp_cleaned: 0
     tx_queue_27_packets: 20610883641
     tx_queue_27_bytes: 5977056630036
     tx_queue_27_bp_napi_yield: 0
     tx_queue_27_bp_misses: 0
     tx_queue_27_bp_cleaned: 0
     tx_queue_28_packets: 540974464
     tx_queue_28_bytes: 242743482436
     tx_queue_28_bp_napi_yield: 0
     tx_queue_28_bp_misses: 0
     tx_queue_28_bp_cleaned: 0
     tx_queue_29_packets: 21929305961
     tx_queue_29_bytes: 6354700102951
     tx_queue_29_bp_napi_yield: 0
     tx_queue_29_bp_misses: 0
     tx_queue_29_bp_cleaned: 0
     tx_queue_30_packets: 543344232
     tx_queue_30_bytes: 244752518152
     tx_queue_30_bp_napi_yield: 0
     tx_queue_30_bp_misses: 0
     tx_queue_30_bp_cleaned: 0
     tx_queue_31_packets: 23255765464
     tx_queue_31_bytes: 6766972152635
     tx_queue_31_bp_napi_yield: 0
     tx_queue_31_bp_misses: 0
     tx_queue_31_bp_cleaned: 0
     tx_queue_32_packets: 0
     tx_queue_32_bytes: 0
     tx_queue_32_bp_napi_yield: 0
     tx_queue_32_bp_misses: 0
     tx_queue_32_bp_cleaned: 0
     tx_queue_33_packets: 0
     tx_queue_33_bytes: 0
     tx_queue_33_bp_napi_yield: 0
     tx_queue_33_bp_misses: 0
     tx_queue_33_bp_cleaned: 0
     tx_queue_34_packets: 0
     tx_queue_34_bytes: 0
     tx_queue_34_bp_napi_yield: 0
     tx_queue_34_bp_misses: 0
     tx_queue_34_bp_cleaned: 0
     tx_queue_35_packets: 0
     tx_queue_35_bytes: 0
     tx_queue_35_bp_napi_yield: 0
     tx_queue_35_bp_misses: 0
     tx_queue_35_bp_cleaned: 0
     tx_queue_36_packets: 0
     tx_queue_36_bytes: 0
     tx_queue_36_bp_napi_yield: 0
     tx_queue_36_bp_misses: 0
     tx_queue_36_bp_cleaned: 0
     tx_queue_37_packets: 0
     tx_queue_37_bytes: 0
     tx_queue_37_bp_napi_yield: 0
     tx_queue_37_bp_misses: 0
     tx_queue_37_bp_cleaned: 0
     tx_queue_38_packets: 0
     tx_queue_38_bytes: 0
     tx_queue_38_bp_napi_yield: 0
     tx_queue_38_bp_misses: 0
     tx_queue_38_bp_cleaned: 0
     tx_queue_39_packets: 0
     tx_queue_39_bytes: 0
     tx_queue_39_bp_napi_yield: 0
     tx_queue_39_bp_misses: 0
     tx_queue_39_bp_cleaned: 0
     tx_queue_40_packets: 0
     tx_queue_40_bytes: 0
     tx_queue_40_bp_napi_yield: 0
     tx_queue_40_bp_misses: 0
     tx_queue_40_bp_cleaned: 0
     tx_queue_41_packets: 0
     tx_queue_41_bytes: 0
     tx_queue_41_bp_napi_yield: 0
     tx_queue_41_bp_misses: 0
     tx_queue_41_bp_cleaned: 0
     tx_queue_42_packets: 0
     tx_queue_42_bytes: 0
     tx_queue_42_bp_napi_yield: 0
     tx_queue_42_bp_misses: 0
     tx_queue_42_bp_cleaned: 0
     tx_queue_43_packets: 0
     tx_queue_43_bytes: 0
     tx_queue_43_bp_napi_yield: 0
     tx_queue_43_bp_misses: 0
     tx_queue_43_bp_cleaned: 0
     tx_queue_44_packets: 0
     tx_queue_44_bytes: 0
     tx_queue_44_bp_napi_yield: 0
     tx_queue_44_bp_misses: 0
     tx_queue_44_bp_cleaned: 0
     tx_queue_45_packets: 0
     tx_queue_45_bytes: 0
     tx_queue_45_bp_napi_yield: 0
     tx_queue_45_bp_misses: 0
     tx_queue_45_bp_cleaned: 0
     tx_queue_46_packets: 0
     tx_queue_46_bytes: 0
     tx_queue_46_bp_napi_yield: 0
     tx_queue_46_bp_misses: 0
     tx_queue_46_bp_cleaned: 0
     tx_queue_47_packets: 0
     tx_queue_47_bytes: 0
     tx_queue_47_bp_napi_yield: 0
     tx_queue_47_bp_misses: 0
     tx_queue_47_bp_cleaned: 0
     tx_queue_48_packets: 0
     tx_queue_48_bytes: 0
     tx_queue_48_bp_napi_yield: 0
     tx_queue_48_bp_misses: 0
     tx_queue_48_bp_cleaned: 0
     tx_queue_49_packets: 0
     tx_queue_49_bytes: 0
     tx_queue_49_bp_napi_yield: 0
     tx_queue_49_bp_misses: 0
     tx_queue_49_bp_cleaned: 0
     tx_queue_50_packets: 0
     tx_queue_50_bytes: 0
     tx_queue_50_bp_napi_yield: 0
     tx_queue_50_bp_misses: 0
     tx_queue_50_bp_cleaned: 0
     tx_queue_51_packets: 0
     tx_queue_51_bytes: 0
     tx_queue_51_bp_napi_yield: 0
     tx_queue_51_bp_misses: 0
     tx_queue_51_bp_cleaned: 0
     tx_queue_52_packets: 0
     tx_queue_52_bytes: 0
     tx_queue_52_bp_napi_yield: 0
     tx_queue_52_bp_misses: 0
     tx_queue_52_bp_cleaned: 0
     tx_queue_53_packets: 0
     tx_queue_53_bytes: 0
     tx_queue_53_bp_napi_yield: 0
     tx_queue_53_bp_misses: 0
     tx_queue_53_bp_cleaned: 0
     tx_queue_54_packets: 0
     tx_queue_54_bytes: 0
     tx_queue_54_bp_napi_yield: 0
     tx_queue_54_bp_misses: 0
     tx_queue_54_bp_cleaned: 0
     tx_queue_55_packets: 0
     tx_queue_55_bytes: 0
     tx_queue_55_bp_napi_yield: 0
     tx_queue_55_bp_misses: 0
     tx_queue_55_bp_cleaned: 0
     tx_queue_56_packets: 0
     tx_queue_56_bytes: 0
     tx_queue_56_bp_napi_yield: 0
     tx_queue_56_bp_misses: 0
     tx_queue_56_bp_cleaned: 0
     tx_queue_57_packets: 0
     tx_queue_57_bytes: 0
     tx_queue_57_bp_napi_yield: 0
     tx_queue_57_bp_misses: 0
     tx_queue_57_bp_cleaned: 0
     tx_queue_58_packets: 0
     tx_queue_58_bytes: 0
     tx_queue_58_bp_napi_yield: 0
     tx_queue_58_bp_misses: 0
     tx_queue_58_bp_cleaned: 0
     tx_queue_59_packets: 0
     tx_queue_59_bytes: 0
     tx_queue_59_bp_napi_yield: 0
     tx_queue_59_bp_misses: 0
     tx_queue_59_bp_cleaned: 0
     tx_queue_60_packets: 0
     tx_queue_60_bytes: 0
     tx_queue_60_bp_napi_yield: 0
     tx_queue_60_bp_misses: 0
     tx_queue_60_bp_cleaned: 0
     tx_queue_61_packets: 0
     tx_queue_61_bytes: 0
     tx_queue_61_bp_napi_yield: 0
     tx_queue_61_bp_misses: 0
     tx_queue_61_bp_cleaned: 0
     tx_queue_62_packets: 0
     tx_queue_62_bytes: 0
     tx_queue_62_bp_napi_yield: 0
     tx_queue_62_bp_misses: 0
     tx_queue_62_bp_cleaned: 0
     tx_queue_63_packets: 0
     tx_queue_63_bytes: 0
     tx_queue_63_bp_napi_yield: 0
     tx_queue_63_bp_misses: 0
     tx_queue_63_bp_cleaned: 0
     rx_queue_0_packets: 5551016663
     rx_queue_0_bytes: 2098203870025
     rx_queue_0_bp_poll_yield: 0
     rx_queue_0_bp_misses: 0
     rx_queue_0_bp_cleaned: 0
     rx_queue_1_packets: 54703135727
     rx_queue_1_bytes: 13942451191895
     rx_queue_1_bp_poll_yield: 0
     rx_queue_1_bp_misses: 0
     rx_queue_1_bp_cleaned: 0
     rx_queue_2_packets: 5307835275
     rx_queue_2_bytes: 2004912052226
     rx_queue_2_bp_poll_yield: 0
     rx_queue_2_bp_misses: 0
     rx_queue_2_bp_cleaned: 0
     rx_queue_3_packets: 24103372517
     rx_queue_3_bytes: 13310520908688
     rx_queue_3_bp_poll_yield: 0
     rx_queue_3_bp_misses: 0
     rx_queue_3_bp_cleaned: 0
     rx_queue_4_packets: 5294144794
     rx_queue_4_bytes: 1997555466924
     rx_queue_4_bp_poll_yield: 0
     rx_queue_4_bp_misses: 0
     rx_queue_4_bp_cleaned: 0
     rx_queue_5_packets: 25225590014
     rx_queue_5_bytes: 14259623662308
     rx_queue_5_bp_poll_yield: 0
     rx_queue_5_bp_misses: 0
     rx_queue_5_bp_cleaned: 0
     rx_queue_6_packets: 5254831679
     rx_queue_6_bytes: 1982554153149
     rx_queue_6_bp_poll_yield: 0
     rx_queue_6_bp_misses: 0
     rx_queue_6_bp_cleaned: 0
     rx_queue_7_packets: 26157776967
     rx_queue_7_bytes: 15062315489385
     rx_queue_7_bp_poll_yield: 0
     rx_queue_7_bp_misses: 0
     rx_queue_7_bp_cleaned: 0
     rx_queue_8_packets: 5273558340
     rx_queue_8_bytes: 1991710810146
     rx_queue_8_bp_poll_yield: 0
     rx_queue_8_bp_misses: 0
     rx_queue_8_bp_cleaned: 0
     rx_queue_9_packets: 27091068343
     rx_queue_9_bytes: 15793117833188
     rx_queue_9_bp_poll_yield: 0
     rx_queue_9_bp_misses: 0
     rx_queue_9_bp_cleaned: 0
     rx_queue_10_packets: 5250476256
     rx_queue_10_bytes: 1988787640417
     rx_queue_10_bp_poll_yield: 0
     rx_queue_10_bp_misses: 0
     rx_queue_10_bp_cleaned: 0
     rx_queue_11_packets: 28415109046
     rx_queue_11_bytes: 16832994028009
     rx_queue_11_bp_poll_yield: 0
     rx_queue_11_bp_misses: 0
     rx_queue_11_bp_cleaned: 0
     rx_queue_12_packets: 5210908806
     rx_queue_12_bytes: 1977566033796
     rx_queue_12_bp_poll_yield: 0
     rx_queue_12_bp_misses: 0
     rx_queue_12_bp_cleaned: 0
     rx_queue_13_packets: 31567245051
     rx_queue_13_bytes: 19179354234370
     rx_queue_13_bp_poll_yield: 0
     rx_queue_13_bp_misses: 0
     rx_queue_13_bp_cleaned: 0
     rx_queue_14_packets: 5186606596
     rx_queue_14_bytes: 1955905395350
     rx_queue_14_bp_poll_yield: 0
     rx_queue_14_bp_misses: 0
     rx_queue_14_bp_cleaned: 0
     rx_queue_15_packets: 38751471569
     rx_queue_15_bytes: 24134668632551
     rx_queue_15_bp_poll_yield: 0
     rx_queue_15_bp_misses: 0
     rx_queue_15_bp_cleaned: 0
     rx_queue_16_packets: 273365798
     rx_queue_16_bytes: 126244277376
     rx_queue_16_bp_poll_yield: 0
     rx_queue_16_bp_misses: 0
     rx_queue_16_bp_cleaned: 0
     rx_queue_17_packets: 26565409264
     rx_queue_17_bytes: 20165361551235
     rx_queue_17_bp_poll_yield: 0
     rx_queue_17_bp_misses: 0
     rx_queue_17_bp_cleaned: 0
     rx_queue_18_packets: 270093324
     rx_queue_18_bytes: 125023140416
     rx_queue_18_bp_poll_yield: 0
     rx_queue_18_bp_misses: 0
     rx_queue_18_bp_cleaned: 0
     rx_queue_19_packets: 24414611308
     rx_queue_19_bytes: 18493514933660
     rx_queue_19_bp_poll_yield: 0
     rx_queue_19_bp_misses: 0
     rx_queue_19_bp_cleaned: 0
     rx_queue_20_packets: 270230445
     rx_queue_20_bytes: 125262756954
     rx_queue_20_bp_poll_yield: 0
     rx_queue_20_bp_misses: 0
     rx_queue_20_bp_cleaned: 0
     rx_queue_21_packets: 24892020340
     rx_queue_21_bytes: 18841455757002
     rx_queue_21_bp_poll_yield: 0
     rx_queue_21_bp_misses: 0
     rx_queue_21_bp_cleaned: 0
     rx_queue_22_packets: 269911410
     rx_queue_22_bytes: 125361467018
     rx_queue_22_bp_poll_yield: 0
     rx_queue_22_bp_misses: 0
     rx_queue_22_bp_cleaned: 0
     rx_queue_23_packets: 25744873302
     rx_queue_23_bytes: 19532484773534
     rx_queue_23_bp_poll_yield: 0
     rx_queue_23_bp_misses: 0
     rx_queue_23_bp_cleaned: 0
     rx_queue_24_packets: 271627923
     rx_queue_24_bytes: 126272401871
     rx_queue_24_bp_poll_yield: 0
     rx_queue_24_bp_misses: 0
     rx_queue_24_bp_cleaned: 0
     rx_queue_25_packets: 26520500836
     rx_queue_25_bytes: 20126084069756
     rx_queue_25_bp_poll_yield: 0
     rx_queue_25_bp_misses: 0
     rx_queue_25_bp_cleaned: 0
     rx_queue_26_packets: 271739347
     rx_queue_26_bytes: 126336580321
     rx_queue_26_bp_poll_yield: 0
     rx_queue_26_bp_misses: 0
     rx_queue_26_bp_cleaned: 0
     rx_queue_27_packets: 27006393306
     rx_queue_27_bytes: 20522331167960
     rx_queue_27_bp_poll_yield: 0
     rx_queue_27_bp_misses: 0
     rx_queue_27_bp_cleaned: 0
     rx_queue_28_packets: 273321913
     rx_queue_28_bytes: 127010652580
     rx_queue_28_bp_poll_yield: 0
     rx_queue_28_bp_misses: 0
     rx_queue_28_bp_cleaned: 0
     rx_queue_29_packets: 28767539432
     rx_queue_29_bytes: 21878090796194
     rx_queue_29_bp_poll_yield: 0
     rx_queue_29_bp_misses: 0
     rx_queue_29_bp_cleaned: 0
     rx_queue_30_packets: 274024682
     rx_queue_30_bytes: 127180614339
     rx_queue_30_bp_poll_yield: 0
     rx_queue_30_bp_misses: 0
     rx_queue_30_bp_cleaned: 0
     rx_queue_31_packets: 30483077205
     rx_queue_31_bytes: 23084193861387
     rx_queue_31_bp_poll_yield: 0
     rx_queue_31_bp_misses: 0
     rx_queue_31_bp_cleaned: 0
     rx_queue_32_packets: 0
     rx_queue_32_bytes: 0
     rx_queue_32_bp_poll_yield: 0
     rx_queue_32_bp_misses: 0
     rx_queue_32_bp_cleaned: 0
     rx_queue_33_packets: 0
     rx_queue_33_bytes: 0
     rx_queue_33_bp_poll_yield: 0
     rx_queue_33_bp_misses: 0
     rx_queue_33_bp_cleaned: 0
     rx_queue_34_packets: 0
     rx_queue_34_bytes: 0
     rx_queue_34_bp_poll_yield: 0
     rx_queue_34_bp_misses: 0
     rx_queue_34_bp_cleaned: 0
     rx_queue_35_packets: 0
     rx_queue_35_bytes: 0
     rx_queue_35_bp_poll_yield: 0
     rx_queue_35_bp_misses: 0
     rx_queue_35_bp_cleaned: 0
     rx_queue_36_packets: 0
     rx_queue_36_bytes: 0
     rx_queue_36_bp_poll_yield: 0
     rx_queue_36_bp_misses: 0
     rx_queue_36_bp_cleaned: 0
     rx_queue_37_packets: 0
     rx_queue_37_bytes: 0
     rx_queue_37_bp_poll_yield: 0
     rx_queue_37_bp_misses: 0
     rx_queue_37_bp_cleaned: 0
     rx_queue_38_packets: 0
     rx_queue_38_bytes: 0
     rx_queue_38_bp_poll_yield: 0
     rx_queue_38_bp_misses: 0
     rx_queue_38_bp_cleaned: 0
     rx_queue_39_packets: 0
     rx_queue_39_bytes: 0
     rx_queue_39_bp_poll_yield: 0
     rx_queue_39_bp_misses: 0
     rx_queue_39_bp_cleaned: 0
     rx_queue_40_packets: 0
     rx_queue_40_bytes: 0
     rx_queue_40_bp_poll_yield: 0
     rx_queue_40_bp_misses: 0
     rx_queue_40_bp_cleaned: 0
     rx_queue_41_packets: 0
     rx_queue_41_bytes: 0
     rx_queue_41_bp_poll_yield: 0
     rx_queue_41_bp_misses: 0
     rx_queue_41_bp_cleaned: 0
     rx_queue_42_packets: 0
     rx_queue_42_bytes: 0
     rx_queue_42_bp_poll_yield: 0
     rx_queue_42_bp_misses: 0
     rx_queue_42_bp_cleaned: 0
     rx_queue_43_packets: 0
     rx_queue_43_bytes: 0
     rx_queue_43_bp_poll_yield: 0
     rx_queue_43_bp_misses: 0
     rx_queue_43_bp_cleaned: 0
     rx_queue_44_packets: 0
     rx_queue_44_bytes: 0
     rx_queue_44_bp_poll_yield: 0
     rx_queue_44_bp_misses: 0
     rx_queue_44_bp_cleaned: 0
     rx_queue_45_packets: 0
     rx_queue_45_bytes: 0
     rx_queue_45_bp_poll_yield: 0
     rx_queue_45_bp_misses: 0
     rx_queue_45_bp_cleaned: 0
     rx_queue_46_packets: 0
     rx_queue_46_bytes: 0
     rx_queue_46_bp_poll_yield: 0
     rx_queue_46_bp_misses: 0
     rx_queue_46_bp_cleaned: 0
     rx_queue_47_packets: 0
     rx_queue_47_bytes: 0
     rx_queue_47_bp_poll_yield: 0
     rx_queue_47_bp_misses: 0
     rx_queue_47_bp_cleaned: 0
     rx_queue_48_packets: 0
     rx_queue_48_bytes: 0
     rx_queue_48_bp_poll_yield: 0
     rx_queue_48_bp_misses: 0
     rx_queue_48_bp_cleaned: 0
     rx_queue_49_packets: 0
     rx_queue_49_bytes: 0
     rx_queue_49_bp_poll_yield: 0
     rx_queue_49_bp_misses: 0
     rx_queue_49_bp_cleaned: 0
     rx_queue_50_packets: 0
     rx_queue_50_bytes: 0
     rx_queue_50_bp_poll_yield: 0
     rx_queue_50_bp_misses: 0
     rx_queue_50_bp_cleaned: 0
     rx_queue_51_packets: 0
     rx_queue_51_bytes: 0
     rx_queue_51_bp_poll_yield: 0
     rx_queue_51_bp_misses: 0
     rx_queue_51_bp_cleaned: 0
     rx_queue_52_packets: 0
     rx_queue_52_bytes: 0
     rx_queue_52_bp_poll_yield: 0
     rx_queue_52_bp_misses: 0
     rx_queue_52_bp_cleaned: 0
     rx_queue_53_packets: 0
     rx_queue_53_bytes: 0
     rx_queue_53_bp_poll_yield: 0
     rx_queue_53_bp_misses: 0
     rx_queue_53_bp_cleaned: 0
     rx_queue_54_packets: 0
     rx_queue_54_bytes: 0
     rx_queue_54_bp_poll_yield: 0
     rx_queue_54_bp_misses: 0
     rx_queue_54_bp_cleaned: 0
     rx_queue_55_packets: 0
     rx_queue_55_bytes: 0
     rx_queue_55_bp_poll_yield: 0
     rx_queue_55_bp_misses: 0
     rx_queue_55_bp_cleaned: 0
     rx_queue_56_packets: 0
     rx_queue_56_bytes: 0
     rx_queue_56_bp_poll_yield: 0
     rx_queue_56_bp_misses: 0
     rx_queue_56_bp_cleaned: 0
     rx_queue_57_packets: 0
     rx_queue_57_bytes: 0
     rx_queue_57_bp_poll_yield: 0
     rx_queue_57_bp_misses: 0
     rx_queue_57_bp_cleaned: 0
     rx_queue_58_packets: 0
     rx_queue_58_bytes: 0
     rx_queue_58_bp_poll_yield: 0
     rx_queue_58_bp_misses: 0
     rx_queue_58_bp_cleaned: 0
     rx_queue_59_packets: 0
     rx_queue_59_bytes: 0
     rx_queue_59_bp_poll_yield: 0
     rx_queue_59_bp_misses: 0
     rx_queue_59_bp_cleaned: 0
     rx_queue_60_packets: 0
     rx_queue_60_bytes: 0
     rx_queue_60_bp_poll_yield: 0
     rx_queue_60_bp_misses: 0
     rx_queue_60_bp_cleaned: 0
     rx_queue_61_packets: 0
     rx_queue_61_bytes: 0
     rx_queue_61_bp_poll_yield: 0
     rx_queue_61_bp_misses: 0
     rx_queue_61_bp_cleaned: 0
     rx_queue_62_packets: 0
     rx_queue_62_bytes: 0
     rx_queue_62_bp_poll_yield: 0
     rx_queue_62_bp_misses: 0
     rx_queue_62_bp_cleaned: 0
     rx_queue_63_packets: 0
     rx_queue_63_bytes: 0
     rx_queue_63_bp_poll_yield: 0
     rx_queue_63_bp_misses: 0
     rx_queue_63_bp_cleaned: 0
     tx_pb_0_pxon: 0
     tx_pb_0_pxoff: 0
     tx_pb_1_pxon: 0
     tx_pb_1_pxoff: 0
     tx_pb_2_pxon: 0
     tx_pb_2_pxoff: 0
     tx_pb_3_pxon: 0
     tx_pb_3_pxoff: 0
     tx_pb_4_pxon: 0
     tx_pb_4_pxoff: 0
     tx_pb_5_pxon: 0
     tx_pb_5_pxoff: 0
     tx_pb_6_pxon: 0
     tx_pb_6_pxoff: 0
     tx_pb_7_pxon: 0
     tx_pb_7_pxoff: 0
     rx_pb_0_pxon: 0
     rx_pb_0_pxoff: 0
     rx_pb_1_pxon: 0
     rx_pb_1_pxoff: 0
     rx_pb_2_pxon: 0
     rx_pb_2_pxoff: 0
     rx_pb_3_pxon: 0
     rx_pb_3_pxoff: 0
     rx_pb_4_pxon: 0
     rx_pb_4_pxoff: 0
     rx_pb_5_pxon: 0
     rx_pb_5_pxoff: 0
     rx_pb_6_pxon: 0
     rx_pb_6_pxoff: 0
     rx_pb_7_pxon: 0
     rx_pb_7_pxoff: 0


~# ethtool -g eth0
Ring parameters for eth0:
Pre-set maximums:
RX:       4096
RX Mini:  0
RX Jumbo: 0
TX:       4096
Current hardware settings:
RX:       512
RX Mini:  0
RX Jumbo: 0
TX:       512


~# cat /sys/class/net/eth0/statistics/rx_dropped
0

~# cat /sys/class/net/eth0/statistics/
collisions           rx_compressed        rx_errors            rx_length_errors     rx_packets           tx_carrier_errors    tx_errors            tx_packets
multicast            rx_crc_errors        rx_fifo_errors       rx_missed_errors     tx_aborted_errors    tx_compressed        tx_fifo_errors       tx_window_errors
rx_bytes             rx_dropped           rx_frame_errors      rx_over_errors       tx_bytes             tx_dropped           tx_heartbeat_errors

~# cat /sys/class/net/eth0/statistics/*
0
0
76933033312740
0
0
0
0
0
0
0
0
0
138559572735
0
37447435582177
0
0
0
0
0
0
129062094151
0

~# cat /proc/net/dev
Inter-|   Receive                                                |  Transmit
 face |bytes    packets errs drop fifo frame compressed multicast|bytes    packets errs drop fifo colls carrier compressed
  eth0: 76933349006466 138560091872    0    0    0     0          0         0 37447579842529 129062569742    0    0    0     0       0          0
docker0: 1733197133 25675190    0    0    0     0          0         0 3233901710 22493856    0    0    0     0       0          0
  eth1:       0       0    0    0    0     0          0         0        0       0    0    0    0     0       0          0
tunnat:       0       0    0    0    0     0          0         0 48888646  806692    0    4    0     0       0          0
    lo: 3599645443113 14497563979    0    0    0     0          0         0 3599645443113 14497563979    0    0    0     0       0          0
 tunl0:       0       0    0    0    0     0          0         0        0       0    0    0    0     0       0          0

 ~# ethtool -l eth0
Channel parameters for eth0:
Pre-set maximums:
RX:       0
TX:       0
Other:         1
Combined: 63
Current hardware settings:
RX:       0
TX:       0
Other:         1
Combined: 32

~# ethtool -x eth0
Cannot get RX flow hash indirection table size: Operation not supported

~# ethtool -c eth0
Coalesce parameters for eth0:
Adaptive RX: off  TX: off
stats-block-usecs: 0
sample-interval: 0
pkt-rate-low: 0
pkt-rate-high: 0

rx-usecs: 1
rx-frames: 0
rx-usecs-irq: 0
rx-frames-irq: 0

tx-usecs: 0
tx-frames: 0
tx-usecs-irq: 0
tx-frames-irq: 0

rx-usecs-low: 0
rx-frame-low: 0
tx-usecs-low: 0
tx-frame-low: 0

rx-usecs-high: 0
rx-frame-high: 0
tx-usecs-high: 0
tx-frame-high: 0

~# cat /proc/irq/101/smp_affinity
0000,00000000,00000000,00000000,80000000

~# cat /proc/net/softnet_stat
019a9dcf 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
e2d5349a 00000000 00000007 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
0182b572 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
4068971d 00000000 00000001 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
015e1dd2 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
3dd01dd8 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
0141bb70 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
3d08834a 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
01303f68 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
38eca1b9 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
0127e9d2 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
3530615d 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
0124585c 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
2e920eb8 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
0125d357 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
8220de60 00000000 00000005 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
0071f8ae 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
48fa45ec 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
00724b7d 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
64c2c4ef 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
00735249 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
687f867c 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
0072b1ba 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
84128aec 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
007365bf 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
87fe0fa1 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
00727da4 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
894fe228 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
0074c994 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
85dcdcf4 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
0079fdf7 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
61283c66 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000

~# sysctl  net.core.netdev_budget
net.core.netdev_budget = 300

~# ethtool -k eth0 | grep generic-receive-offload
generic-receive-offload: on

~# cat /sys/class/net/eth0/queues/rx-0/rps_cpus
00000000,00000000,00000000,00000000,00000000,00000000,00000000,00000000

~# sysctl net.core.rps_sock_flow_entries
net.core.rps_sock_flow_entries = 0

~# cat /sys/class/net/eth0/queues/rx-0/rps_flow_cnt
0

~# sysctl net.core.netdev_tstamp_prequeue
net.core.netdev_tstamp_prequeue = 1

~# sysctl net.core.netdev_max_backlog
net.core.netdev_max_backlog = 65535

~# sysctl net.core.dev_weight
net.core.dev_weight = 64

~# sysctl net.core.flow_limit_table_len
net.core.flow_limit_table_len = 4096

~# cat /proc/sys/net/core/flow_limit_cpu_bitmap
00000000,00000000,00000000,00000000,00000000,00000000,00000000,00000000

~# sysctl net.ipv4.ip_early_demux
net.ipv4.ip_early_demux = 1

~# cat /proc/net/snmp
Ip: Forwarding DefaultTTL InReceives InHdrErrors InAddrErrors ForwDatagrams InUnknownProtos InDiscards InDelivers OutRequests OutDiscards OutNoRoutes ReasmTimeout ReasmReqds ReasmOKs ReasmFails FragOKs FragFails FragCreates
Ip: 2 64 91795877915 0 210204370 0 0 0 91532959246 30673053594 0 193 0 104986696 52272397 0 0 0 0
Icmp: InMsgs InErrors InCsumErrors InDestUnreachs InTimeExcds InParmProbs InSrcQuenchs InRedirects InEchos InEchoReps InTimestamps InTimestampReps InAddrMasks InAddrMaskReps OutMsgs OutErrors OutDestUnreachs OutTimeExcds OutParmProbs OutSrcQuenchs OutRedirects OutEchos OutEchoReps OutTimestamps OutTimestampReps OutAddrMasks OutAddrMaskReps
Icmp: 15117520 0 0 20265 29 0 0 0 15097115 111 0 0 0 0 15245546 0 148115 0 0 0 0 316 15097115 0 0 0 0
IcmpMsg: InType0 InType3 InType8 InType11 OutType0 OutType3 OutType8
IcmpMsg: 111 20265 15097115 29 15097115 148115 316
Tcp: RtoAlgorithm RtoMin RtoMax MaxConn ActiveOpens PassiveOpens AttemptFails EstabResets CurrEstab InSegs OutSegs RetransSegs InErrs OutRsts InCsumErrors
Tcp: 1 200 120000 -1 133327105 80737809 361779 7392435 29 52705179293 31524264991 537197 1370 30466805 0
Udp: InDatagrams NoPorts InErrors OutDatagrams RcvbufErrors SndbufErrors InCsumErrors IgnoredMulti
Udp: 38763043221 47587756 1904268 2023128 1904268 0 0 146191
UdpLite: InDatagrams NoPorts InErrors OutDatagrams RcvbufErrors SndbufErrors InCsumErrors IgnoredMulti
UdpLite: 0 0 0 0 0 0 0 0

~# cat /proc/net/netstat
TcpExt: SyncookiesSent SyncookiesRecv SyncookiesFailed EmbryonicRsts PruneCalled RcvPruned OfoPruned OutOfWindowIcmps LockDroppedIcmps ArpFilter TW TWRecycled TWKilled PAWSPassive PAWSActive PAWSEstab DelayedACKs DelayedACKLocked DelayedACKLost ListenOverflows ListenDrops TCPPrequeued TCPDirectCopyFromBacklog TCPDirectCopyFromPrequeue TCPPrequeueDropped TCPHPHits TCPHPHitsToUser TCPPureAcks TCPHPAcks TCPRenoRecovery TCPSackRecovery TCPSACKReneging TCPFACKReorder TCPSACKReorder TCPRenoReorder TCPTSReorder TCPFullUndo TCPPartialUndo TCPDSACKUndo TCPLossUndo TCPLostRetransmit TCPRenoFailures TCPSackFailures TCPLossFailures TCPFastRetrans TCPForwardRetrans TCPSlowStartRetrans TCPTimeouts TCPLossProbes TCPLossProbeRecovery TCPRenoRecoveryFail TCPSackRecoveryFail TCPSchedulerFailed TCPRcvCollapsed TCPDSACKOldSent TCPDSACKOfoSent TCPDSACKRecv TCPDSACKOfoRecv TCPAbortOnData TCPAbortOnClose TCPAbortOnMemory TCPAbortOnTimeout TCPAbortOnLinger TCPAbortFailed TCPMemoryPressures TCPSACKDiscard TCPDSACKIgnoredOld TCPDSACKIgnoredNoUndo TCPSpuriousRTOs TCPMD5NotFound TCPMD5Unexpected TCPSackShifted TCPSackMerged TCPSackShiftFallback TCPBacklogDrop TCPMinTTLDrop TCPDeferAcceptDrop IPReversePathFilter TCPTimeWaitOverflow TCPReqQFullDoCookies TCPReqQFullDrop TCPRetransFail TCPRcvCoalesce TCPOFOQueue TCPOFODrop TCPOFOMerge TCPChallengeACK TCPSYNChallenge TCPFastOpenActive TCPFastOpenActiveFail TCPFastOpenPassive TCPFastOpenPassiveFail TCPFastOpenListenOverflow TCPFastOpenCookieReqd TCPSpuriousRtxHostQueues BusyPollRxPackets TCPAutoCorking TCPFromZeroWindowAdv TCPToZeroWindowAdv TCPWantZeroWindowAdv TCPSynRetrans TCPOrigDataSent TCPHystartTrainDetect TCPHystartTrainCwnd TCPHystartDelayDetect TCPHystartDelayCwnd
TcpExt: 0 0 0 122 682 0 0 42 0 0 88533522 0 64201646 17 0 1 37333181 22400 3347767 0 17 1163617216 3464480712 423292286067 0 49750058725 178071932 535008933 12932083796 9 249223 0 49 635 0 0 3556 950 104951 12873 3774 0 5313 192 289879 9995 4977 28676 201786 107243 0 3026 207 44898 3189289 420 199104 938 7245526 65530 0 10373 0 0 0 0 388 66403 1647 0 0 255965 302223 1049259 0 0 0 0 6405403 0 0 0 31277283037 6377094 0 414 134439 1376 0 0 0 0 0 0 40 0 331369169 1288 1288 437925 36450 15712250527 49216 977081 542 40021
IpExt: InNoRoutes InTruncatedPkts InMcastPkts OutMcastPkts InBcastPkts OutBcastPkts InOctets OutOctets InMcastOctets OutMcastOctets InBcastOctets OutBcastOctets InCsumErrors InNoECTPkts InECT1Pkts InECT0Pkts InCEPkts
IpExt: 0 0 63536 63616 146191 0 40347513394529 5553031883393 13667484 13670684 24090737 0 0 91797341955 0 133464 0

~# sysctl net.core.rmem_max
net.core.rmem_max = 16777216

~# cat /proc/net/udp
  sl  local_address rem_address   st tx_queue rx_queue tr tm->when retrnsmt   uid  timeout inode ref pointer drops
23956: 00000000:2710 00000000:0000 07 00000000:00000000 00:00000000 00000000  1000        0 1318784379 2 ffff88202d601e00 2752
39814: 00000000:6502 00000000:0000 07 00000000:00000000 00:00000000 00000000     0        0 3320188 2 ffff882033e27440 1084523
39815: 00000000:6503 00000000:0000 07 00000000:00000000 00:00000000 00000000  1000        0 562543584 2 ffff88202d600f00 789039

~# cat /proc/net/tcp
  sl  local_address rem_address   st tx_queue rx_queue tr tm->when retrnsmt   uid  timeout inode
   0: 00000000:2742 00000000:0000 0A 00000000:00000000 00:00000000 00000000  1001        0 202146236 1 ffff880d04abe580 100 0 0 10 0
   1: 00000000:06A4 00000000:0000 0A 00000000:00000000 00:00000000 00000000     0        0 1222091558 1 ffff880564428e80 100 0 0 10 0
   2: 0100007F:2329 00000000:0000 0A 00000000:00000000 00:00000000 00000000     0        0 1329560920 1 ffff881bdae38e80 100 0 0 10 0
   3: 0100007F:17EB 00000000:0000 0A 00000000:00000000 00:00000000 00000000  1000        0 740684697 1 ffff8801d664b2c0 100 0 0 10 0
   4: 00000000:906E 00000000:0000 0A 00000000:00000000 00:00000000 00000000  1000        0 740719834 1 ffff881097c53a00 100 0 0 10 0
   5: 00000000:162E 00000000:0000 0A 00000000:00000000 00:00000000 00000000  1002        0 168016694 1 ffff88103542cfc0 100 0 0 10 0
   6: 00000000:270F 00000000:0000 0A 00000000:00000000 00:00000000 00000000  1000        0 658809644 1 ffff88102b879d00 100 0 0 10 0
   7: 00000000:0050 00000000:0000 0A 00000000:00000000 00:00000000 00000000     0        0 1222091557 1 ffff88056442b2c0 100 0 0 10 0
   8: 00000000:0051 00000000:0000 0A 00000000:00000000 00:00000000 00000000     0        0 1222091559 1 ffff880564428000 100 0 0 10 0
   9: 00000000:1F91 00000000:0000 0A 00000000:00000000 00:00000000 00000000  1000        0 740719832 1 ffff881097c532c0 100 0 0 10 0
  10: 00000000:2D94 00000000:0000 0A 00000000:00000000 00:00000000 00000000  1000        0 620258671 1 ffff88040fdf8000 100 0 0 10 0
  11: 00000000:1E14 00000000:0000 0A 00000000:00000000 00:00000000 00000000  1002        0 168032114 1 ffff880176bd8e80 100 0 0 10 0
  12: 00000000:0016 00000000:0000 0A 00000000:00000000 00:00000000 00000000     0        0 484 1 ffff88102b878000 100 0 0 10 0
  13: 68517E0A:CF43 D2597E0A:A1CC 01 00000000:00000000 02:00002146 00000000  1002        0 168032119 2 ffff880176bd95c0 20 0 0 10 -1
  14: 68517E0A:2742 595D7E0A:4DEF 06 00000000:00000000 03:00000435 00000000     0        0 0 3 ffff8812d944ca00
  15: 0100007F:2CFF 0100007F:06A4 06 00000000:00000000 03:0000035E 00000000     0        0 0 3 ffff880113dd4400
  16: 68517E0A:2742 595D7E0A:6AC9 06 00000000:00000000 03:0000127A 00000000     0        0 0 3 ffff881438bb5300
  17: 0100007F:2329 0100007F:5E48 06 00000000:00000000 03:0000081D 00000000     0        0 0 3 ffff88148195ae00
  18: 68517E0A:30D5 D35B7E0A:2384 01 00000000:00000000 02:000033AC 00000000  1000        0 740784105 3 ffff8810d2272440 21 4 17 3 2
  19: 68517E0A:6BA5 BAD77E0A:0050 06 00000000:00000000 03:00000A7A 00000000     0        0 0 3 ffff881327d96600
  20: 68517E0A:2742 595D7E0A:725E 06 00000000:00000000 03:00001561 00000000     0        0 0 3 ffff881327d94700
  21: 0100007F:2329 0100007F:5E32 06 00000000:00000000 03:00000169 00000000     0        0 0 3 ffff880113dd6000
  22: 68517E0A:1F91 2216F90A:C299 01 00000000:00000000 00:00000000 00000000  1000        0 740712234 1 ffff8810d2274880 24 4 23 6 4
  23: 68517E0A:3327 68517E0A:06A4 06 00000000:00000000 03:0000120E 00000000     0        0 0 3 ffff881481959f00
  24: 68517E0A:2742 595D7E0A:B98C 06 00000000:00000000 03:0000021F 00000000     0        0 0 3 ffff88113e8d5900
  25: 68517E0A:2742 595D7E0A:0863 06 00000000:00000000 03:0000112E 00000000     0        0 0 3 ffff881438bb4700
  26: 68517E0A:73A9 D95B7E0A:2454 06 00000000:00000000 03:00000CA6 00000000     0        0 0 3 ffff8810bb591800
  27: 68517E0A:2742 595D7E0A:31C4 06 00000000:00000000 03:00001637 00000000     0        0 0 3 ffff881327d95800
  28: 68517E0A:2742 595D7E0A:0E54 06 00000000:00000000 03:00001637 00000000     0        0 0 3 ffff881438bb6600
  29: 68517E0A:DC7A 24677E0A:2384 01 0000004C:00000000 01:00000014 00000000  1000        0 1296552232 4 ffff88103051ba00 20 4 1 2 2
  30: 68517E0A:C3B4 D15B7E0A:2384 01 00000000:00000000 02:0000C879 00000000  1000        0 620294829 2 ffff88146d077400 20 4 29 10 -1
  31: 68517E0A:2742 595D7E0A:4811 06 00000000:00000000 03:00000654 00000000     0        0 0 3 ffff881438b72500
  32: 68517E0A:2742 595D7E0A:17EA 06 00000000:00000000 03:00000A7F 00000000     0        0 0 3 ffff881789598d00
  33: 68517E0A:2742 595D7E0A:0831 06 00000000:00000000 03:000009A6 00000000     0        0 0 3 ffff881327d95e00
  34: 68517E0A:2742 595D7E0A:76B7 06 00000000:00000000 03:0000049C 00000000     0        0 0 3 ffff88178959ac00
  35: 68517E0A:2742 595D7E0A:7536 06 00000000:00000000 03:00000C95 00000000     0        0 0 3 ffff881438b73600
  36: 68517E0A:2742 595D7E0A:717C 06 00000000:00000000 03:0000105D 00000000     0        0 0 3 ffff881438b70800
  37: 68517E0A:2742 595D7E0A:B90A 06 00000000:00000000 03:0000035C 00000000     0        0 0 3 ffff881789598100
  38: 68517E0A:2742 595D7E0A:D742 06 00000000:00000000 03:000011A2 00000000     0        0 0 3 ffff8812d944d400
  39: 68517E0A:C3B3 D15B7E0A:2384 01 00000000:00000000 02:00004A13 00000000  1000        0 620294828 2 ffff88146d076580 20 4 30 7 7
  40: 68517E0A:2742 595D7E0A:7021 06 00000000:00000000 03:000001B2 00000000     0        0 0 3 ffff88113e8d5a00
  41: 68517E0A:2742 595D7E0A:A7D0 06 00000000:00000000 03:000005CD 00000000     0        0 0 3 ffff881438b71400
  42: 68517E0A:2742 595D7E0A:696F 06 00000000:00000000 03:00001423 00000000     0        0 0 3 ffff881327d97d00
  43: 68517E0A:E059 21677E0A:2384 01 0000004C:00000000 01:00000014 00000000  1000        0 1296540459 4 ffff880108ca8e80 20 4 1 2 2
  44: 0100007F:2D0A 0100007F:06A4 06 00000000:00000000 03:0000074E 00000000     0        0 0 3 ffff880113dd6700
  45: 0100007F:2329 0100007F:5E3D 06 00000000:00000000 03:00000748 00000000     0        0 0 3 ffff880113dd7500
  46: 0100007F:2D27 0100007F:06A4 06 00000000:00000000 03:00000DFD 00000000     0        0 0 3 ffff88148195ab00
  47: 68517E0A:3325 68517E0A:06A4 06 00000000:00000000 03:00001198 00000000     0        0 0 3 ffff88148195a600
  48: 68517E0A:0016 0614090A:E453 01 00000000:00000000 02:000002E0 00000000     0        0 1413204264 2 ffff881144ac6cc0 20 4 14 10 43
  49: 68517E0A:E61F 457D7E0A:0016 01 00000000:00000000 02:00005E13 00000000  1000        0 339436477 2 ffff8813c4e08000 20 4 0 10 16
  50: 0100007F:2329 0100007F:5E40 06 00000000:00000000 03:0000074E 00000000     0        0 0 3 ffff880113dd6e00
  51: 68517E0A:D5C5 49C2300A:20F1 01 00000000:00000000 00:00000000 00000000     0        0 1372118632 1 ffff880104157400 20 4 26 20 16
  52: 68517E0A:2742 595D7E0A:2A9F 06 00000000:00000000 03:0000119A 00000000     0        0 0 3 ffff881327d97300
  53: 68517E0A:2742 595D7E0A:0618 06 00000000:00000000 03:000005E8 00000000     0        0 0 3 ffff881327d96700
  54: 68517E0A:E855 D15B7E0A:2384 01 00000000:00000000 02:00009EE0 00000000  1000        0 1413399518 2 ffff88113c6a5700 20 0 0 10 -1
  55: 68517E0A:2742 595D7E0A:3FE4 06 00000000:00000000 03:00000FF0 00000000     0        0 0 3 ffff881327d96300
  56: 68517E0A:2742 595D7E0A:5736 06 00000000:00000000 03:00000DD8 00000000     0        0 0 3 ffff881327d95100
  57: 68517E0A:1F91 7116F90A:C3BE 01 00000000:00000000 00:00000000 00000000  1000        0 1370969951 1 ffff8803f584c880 23 6 23 2 2
  58: 0100007F:2D0C 0100007F:06A4 06 00000000:00000000 03:00000750 00000000     0        0 0 3 ffff880113dd7d00
  59: 68517E0A:995F 9CD77E0A:0050 06 00000000:00000000 03:00000C92 00000000     0        0 0 3 ffff881438b2d900
  60: 68517E0A:2742 595D7E0A:2A5D 06 00000000:00000000 03:00000147 00000000     0        0 0 3 ffff88113e8d7500
  61: 0100007F:2D12 0100007F:06A4 06 00000000:00000000 03:0000081D 00000000     0        0 0 3 ffff881481959a00
  62: 68517E0A:2742 595D7E0A:699F 06 00000000:00000000 03:000005E8 00000000     0        0 0 3 ffff881327d94500
  63: 0100007F:2329 0100007F:5E42 06 00000000:00000000 03:00000750 00000000     0        0 0 3 ffff880113dd4d00
  64: 68517E0A:2742 595D7E0A:B0A7 06 00000000:00000000 03:000005E2 00000000     0        0 0 3 ffff881327d96400
  65: 68517E0A:2742 595D7E0A:481E 06 00000000:00000000 03:00000C2D 00000000     0        0 0 3 ffff8812d944dd00
  66: 68517E0A:2742 595D7E0A:3088 06 00000000:00000000 03:000006BE 00000000     0        0 0 3 ffff881327d94f00
  67: 68517E0A:32FC 68517E0A:06A4 06 00000000:00000000 03:00000652 00000000     0        0 0 3 ffff880113dd5400
  68: 68517E0A:2742 595D7E0A:10D9 06 00000000:00000000 03:00000C2B 00000000     0        0 0 3 ffff881438b2df00
  69: 68517E0A:2742 595D7E0A:7061 06 00000000:00000000 03:0000148B 00000000     0        0 0 3 ffff881438bb7a00
  70: 68517E0A:2742 595D7E0A:E017 06 00000000:00000000 03:0000169D 00000000     0        0 0 3 ffff881327d97c00
  71: 68517E0A:2742 595D7E0A:6D87 06 00000000:00000000 03:00001489 00000000     0        0 0 3 ffff881343d08100
  72: 68517E0A:6F62 CF597E0A:A1CC 01 00000000:00000000 02:000062E0 00000000  1002        0 1411281803 2 ffff8814376eba00 20 4 0 26 25
  73: 68517E0A:2742 595D7E0A:247E 06 00000000:00000000 03:0000141F 00000000     0        0 0 3 ffff8812d944f700
  74: 68517E0A:C4C4 D85B7E0A:2454 06 00000000:00000000 03:00000CA1 00000000     0        0 0 3 ffff88148195a800
  75: 0100007F:2D0E 0100007F:06A4 06 00000000:00000000 03:00000751 00000000     0        0 0 3 ffff880113dd6c00
  76: 68517E0A:2742 595D7E0A:2EBB 06 00000000:00000000 03:00000B4E 00000000     0        0 0 3 ffff8812d944c100
  77: 68517E0A:2742 595D7E0A:342A 06 00000000:00000000 03:00000EA8 00000000     0        0 0 3 ffff881327d94300
  78: 0100007F:2D33 0100007F:06A4 06 00000000:00000000 03:000012B0 00000000     0        0 0 3 ffff881481959300
  79: 68517E0A:2742 595D7E0A:C98C 06 00000000:00000000 03:00000654 00000000     0        0 0 3 ffff8812d944ff00
  80: 68517E0A:2742 595D7E0A:4EC3 06 00000000:00000000 03:000003C5 00000000     0        0 0 3 ffff881438b2fd00
  81: 68517E0A:C4BC D85B7E0A:2454 06 00000000:00000000 03:00000C69 00000000     0        0 0 3 ffff881343d09300
  82: 68517E0A:F007 D7597E0A:A1CC 01 00000000:00000000 02:0000D6E0 00000000  1002        0 1396743657 2 ffff880101c3a440 20 4 0 26 25
  83: 0100007F:2329 0100007F:5E46 06 00000000:00000000 03:00000752 00000000     0        0 0 3 ffff880113dd6f00
  84: 68517E0A:2742 595D7E0A:C5AA 06 00000000:00000000 03:00000D6C 00000000     0        0 0 3 ffff881327d95a00
  85: 68517E0A:2742 595D7E0A:A77A 06 00000000:00000000 03:000013B9 00000000     0        0 0 3 ffff881327d95000
  86: 68517E0A:2742 595D7E0A:0F5B 06 00000000:00000000 03:0000093B 00000000     0        0 0 3 ffff8812d944c300
  87: 68517E0A:2742 595D7E0A:F45F 06 00000000:00000000 03:000014F8 00000000     0        0 0 3 ffff881327d95c00
  88: 68517E0A:2742 595D7E0A:F214 06 00000000:00000000 03:00000652 00000000     0        0 0 3 ffff881438b2c800
  89: 68517E0A:9AFE 22677E0A:0885 01 00000000:00000000 00:00000000 00000000  1000        0 249757976 1 ffff880d61e22b80 20 4 30 4 7
  90: 68517E0A:995E 9CD77E0A:0050 06 00000000:00000000 03:00000C92 00000000     0        0 0 3 ffff881327d95f00
  91: 68517E0A:2742 595D7E0A:C8C7 06 00000000:00000000 03:00000504 00000000     0        0 0 3 ffff881327d97600
  92: 68517E0A:3322 68517E0A:06A4 06 00000000:00000000 03:000010C6 00000000     0        0 0 3 ffff88148195a200
  93: 68517E0A:2742 595D7E0A:9FEC 06 00000000:00000000 03:00001707 00000000     0        0 0 3 ffff881327d96800
  94: 68517E0A:2742 595D7E0A:A34E 06 00000000:00000000 03:00000504 00000000     0        0 0 3 ffff881438b2d500
  95: 68517E0A:2742 595D7E0A:B85D 06 00000000:00000000 03:00000579 00000000     0        0 0 3 ffff881438b2f500
  96: 68517E0A:2742 595D7E0A:D3FE 06 00000000:00000000 03:000008CF 00000000     0        0 0 3 ffff881327d94a00
  97: 68517E0A:2742 595D7E0A:BA3E 06 00000000:00000000 03:000006BE 00000000     0        0 0 3 ffff881327d95d00
  98: 68517E0A:32F9 68517E0A:06A4 06 00000000:00000000 03:00000505 00000000     0        0 0 3 ffff880113dd4a00
  99: 68517E0A:2742 595D7E0A:E62A 06 00000000:00000000 03:000004FF 00000000     0        0 0 3 ffff881327d94d00
 100: 68517E0A:2742 595D7E0A:B0E3 06 00000000:00000000 03:000000E2 00000000     0        0 0 3 ffff881438bb4000
 101: 68517E0A:2742 595D7E0A:50B4 06 00000000:00000000 03:000010C4 00000000     0        0 0 3 ffff8812d944d500
 102: 68517E0A:2742 595D7E0A:47E4 06 00000000:00000000 03:000010C6 00000000     0        0 0 3 ffff881327d94600
 103: 0100007F:2D07 0100007F:06A4 06 00000000:00000000 03:00000748 00000000     0        0 0 3 ffff880113dd4200
 104: 68517E0A:2742 595D7E0A:5B19 06 00000000:00000000 03:00000D02 00000000     0        0 0 3 ffff881327d96d00
 105: 68517E0A:3312 68517E0A:06A4 06 00000000:00000000 03:00000C7D 00000000     0        0 0 3 ffff88148195a000
 106: 68517E0A:2742 595D7E0A:1B24 06 00000000:00000000 03:00000506 00000000     0        0 0 3 ffff8812d944d900
 107: 68517E0A:2742 595D7E0A:D100 06 00000000:00000000 03:0000119D 00000000     0        0 0 3 ffff881327d97100
 108: 0100007F:2CFC 0100007F:06A4 06 00000000:00000000 03:00000168 00000000     0        0 0 3 ffff880113dd7a00
 109: 68517E0A:C4C8 D85B7E0A:2454 06 00000000:00000000 03:00000CA4 00000000     0        0 0 3 ffff8810bb593700
 110: 68517E0A:2742 595D7E0A:921E 06 00000000:00000000 03:0000057A 00000000     0        0 0 3 ffff88178959a300
 111: 68517E0A:1F91 6B12F90A:EC60 01 00000000:00000000 00:00000000 00000000  1000        0 765599662 1 ffff8810d2273a00 27 4 29 3 2
 112: 0100007F:2329 0100007F:5E63 06 00000000:00000000 03:00001182 00000000     0        0 0 3 ffff881481959e00
 113: 68517E0A:2742 595D7E0A:F96B 06 00000000:00000000 03:0000049B 00000000     0        0 0 3 ffff881327d95900
 114: 68517E0A:DDB3 D15B7E0A:2384 01 00000000:00000000 02:000037AC 00000000  1000        0 740767668 3 ffff880100c732c0 21 4 1 2 2
 115: 0100007F:2329 0100007F:5E69 06 00000000:00000000 03:000012AF 00000000     0        0 0 3 ffff88148195a100
 116: 68517E0A:2742 595D7E0A:D693 06 00000000:00000000 03:000005E5 00000000     0        0 0 3 ffff881327d94100
 117: 68517E0A:C4C5 D85B7E0A:2454 06 00000000:00000000 03:00000CA1 00000000     0        0 0 3 ffff881481959b00
 118: 68517E0A:2742 595D7E0A:068D 06 00000000:00000000 03:00000D01 00000000     0        0 0 3 ffff881438b72e00
 119: 68517E0A:2742 595D7E0A:F129 06 00000000:00000000 03:000016A1 00000000     0        0 0 3 ffff881327d96b00
 120: 68517E0A:2742 595D7E0A:ECD4 06 00000000:00000000 03:0000105D 00000000     0        0 0 3 ffff881327d94900
 121: 0100007F:2329 0100007F:5E35 06 00000000:00000000 03:0000035E 00000000     0        0 0 3 ffff880113dd6100
 122: 68517E0A:2742 595D7E0A:9B94 06 00000000:00000000 03:000005DD 00000000     0        0 0 3 ffff881327d95500
 123: 68517E0A:2742 595D7E0A:74BF 06 00000000:00000000 03:000010C4 00000000     0        0 0 3 ffff881327d94400
 124: 68517E0A:2742 595D7E0A:B75B 06 00000000:00000000 03:00001131 00000000     0        0 0 3 ffff881327d96200
 125: 68517E0A:2742 595D7E0A:0F40 06 00000000:00000000 03:000012E2 00000000     0        0 0 3 ffff88178959b600
 126: 68517E0A:2742 595D7E0A:110F 06 00000000:00000000 03:0000112F 00000000     0        0 0 3 ffff881327d97700
 127: 68517E0A:2742 595D7E0A:94C8 06 00000000:00000000 03:0000035C 00000000     0        0 0 3 ffff881438bb6e00
 128: 68517E0A:DE24 D15B7E0A:2384 01 00000000:00000000 02:00013EDF 00000000  1000        0 740797467 2 ffff880100c75e40 20 4 18 3 2
 129: 68517E0A:2742 595D7E0A:5AC6 06 00000000:00000000 03:00000AE8 00000000     0        0 0 3 ffff881327d96e00
 130: 68517E0A:2742 595D7E0A:762D 06 00000000:00000000 03:00000A13 00000000     0        0 0 3 ffff8811055b5d00
 131: 68517E0A:2742 595D7E0A:D43A 06 00000000:00000000 03:00000F86 00000000     0        0 0 3 ffff881327d95200
 132: 68517E0A:CF42 D2597E0A:A1CC 01 00000000:00000000 02:00002146 00000000  1002        0 168023818 2 ffff880104f38e80 20 0 0 10 -1
 133: 0100007F:2D2D 0100007F:06A4 06 00000000:00000000 03:00001182 00000000     0        0 0 3 ffff881481959d00
 134: 68517E0A:BA04 0AC2300A:20F1 01 00000000:00000000 00:00000000 00000000     0        0 1372131473 1 ffff880439a25700 20 4 30 10 19
 135: 68517E0A:1F91 2216F90A:C4DF 01 00000000:00000000 00:00000000 00000000  1000        0 740799791 1 ffff881513e52440 23 6 25 7 7
 136: 68517E0A:2742 595D7E0A:F654 06 00000000:00000000 03:00001706 00000000     0        0 0 3 ffff881327d94000
 137: 0100007F:2329 0100007F:5E44 06 00000000:00000000 03:00000751 00000000     0        0 0 3 ffff880113dd5f00
 138: 0100007F:2329 0100007F:5E50 06 00000000:00000000 03:00000C6A 00000000     0        0 0 3 ffff88148195af00
 139: 68517E0A:32FB 68517E0A:06A4 06 00000000:00000000 03:000005E5 00000000     0        0 0 3 ffff880113dd4f00
 140: 68517E0A:554F 23677E0A:2384 01 0000004C:00000000 01:00000014 00000000  1000        0 1296551158 4 ffff8810d0781d00 20 4 1 2 2
 141: 68517E0A:2742 595D7E0A:48E8 06 00000000:00000000 03:000011A4 00000000     0        0 0 3 ffff881327d97000
 142: 68517E0A:2742 595D7E0A:358A 06 00000000:00000000 03:00000F18 00000000     0        0 0 3 ffff881343d0a400
 143: 68517E0A:2742 595D7E0A:1768 06 00000000:00000000 03:00000EB2 00000000     0        0 0 3 ffff881327d96c00
 144: 68517E0A:2742 595D7E0A:0C89 06 00000000:00000000 03:0000120F 00000000     0        0 0 3 ffff881343d0ac00
 145: 68517E0A:2742 595D7E0A:C521 06 00000000:00000000 03:00000573 00000000     0        0 0 3 ffff881327d96000
 146: 68517E0A:EBDD D35B7E0A:2384 01 00000000:00000000 02:0000A2DF 00000000  1000        0 620294831 3 ffff88146d0715c0 20 4 29 7 7
 147: 68517E0A:2742 595D7E0A:1631 06 00000000:00000000 03:000001B2 00000000     0        0 0 3 ffff881343d0b700
 148: 68517E0A:2742 595D7E0A:A08D 06 00000000:00000000 03:00001560 00000000     0        0 0 3 ffff881327d94b00
 149: 68517E0A:2742 595D7E0A:C30F 06 00000000:00000000 03:0000120D 00000000     0        0 0 3 ffff881327d96a00
 150: 68517E0A:C4BB D85B7E0A:2454 06 00000000:00000000 03:00000C68 00000000     0        0 0 3 ffff881343d09000
 151: 68517E0A:2742 595D7E0A:764A 06 00000000:00000000 03:00000724 00000000     0        0 0 3 ffff881327d96900
 152: 68517E0A:2742 595D7E0A:98F7 06 00000000:00000000 03:00000867 00000000     0        0 0 3 ffff881789599c00
 153: 68517E0A:2742 595D7E0A:B4D9 06 00000000:00000000 03:00000289 00000000     0        0 0 3 ffff8811055b5200
 154: 68517E0A:2742 595D7E0A:60BE 06 00000000:00000000 03:00001130 00000000     0        0 0 3 ffff88178959a100
 155: 68517E0A:2742 595D7E0A:1378 06 00000000:00000000 03:000002F2 00000000     0        0 0 3 ffff88113e8d5400
 156: 68517E0A:3321 68517E0A:06A4 06 00000000:00000000 03:0000105E 00000000     0        0 0 3 ffff88148195ac00
 157: 68517E0A:2742 595D7E0A:E76E 06 00000000:00000000 03:0000093A 00000000     0        0 0 3 ffff881327d97500
 158: 68517E0A:2742 595D7E0A:F80B 06 00000000:00000000 03:0000049C 00000000     0        0 0 3 ffff881327d97900
 159: 68517E0A:2742 595D7E0A:216B 06 00000000:00000000 03:0000120E 00000000     0        0 0 3 ffff881438b2e300
 160: 68517E0A:2742 595D7E0A:BAB2 06 00000000:00000000 03:000000E0 00000000     0        0 0 3 ffff88113e8d5e00
 161: 68517E0A:2742 595D7E0A:F1BD 06 00000000:00000000 03:0000119E 00000000     0        0 0 3 ffff881438bb5100
 162: 68517E0A:ABD9 070A310A:20F1 01 00000000:00000000 00:00000000 00000000     0        0 1372128531 1 ffff8801009b9d00 20 4 26 10 18
 163: 68517E0A:2742 595D7E0A:BCF2 06 00000000:00000000 03:000015C9 00000000     0        0 0 3 ffff881438b71d00
 164: 68517E0A:6BA9 BAD77E0A:0050 06 00000000:00000000 03:00000C6C 00000000     0        0 0 3 ffff881327d94e00
 165: 68517E0A:1F91 6B12F90A:E669 01 00000000:00000000 00:00000000 00000000  1000        0 765392621 1 ffff8810d07832c0 27 4 29 3 2
 166: 68517E0A:2742 595D7E0A:1BE1 06 00000000:00000000 03:0000105E 00000000     0        0 0 3 ffff881327d97200
 167: 68517E0A:32FA 68517E0A:06A4 06 00000000:00000000 03:000005CD 00000000     0        0 0 3 ffff880113dd7100
 168: 68517E0A:2742 595D7E0A:7C68 06 00000000:00000000 03:000002F4 00000000     0        0 0 3 ffff881327d94200
 169: 68517E0A:2742 595D7E0A:875F 06 00000000:00000000 03:000006BA 00000000     0        0 0 3 ffff881438b2f400
 170: 68517E0A:2742 595D7E0A:9B60 06 00000000:00000000 03:00000F1D 00000000     0        0 0 3 ffff881438b71a00
 171: 0100007F:2D1A 0100007F:06A4 06 00000000:00000000 03:00000C6A 00000000     0        0 0 3 ffff88148195ad00
 172: 68517E0A:2742 595D7E0A:E4A3 06 00000000:00000000 03:000014F5 00000000     0        0 0 3 ffff881327d94800
 173: 0100007F:2D10 0100007F:06A4 06 00000000:00000000 03:00000752 00000000     0        0 0 3 ffff880113dd4e00
 174: 68517E0A:2742 595D7E0A:B07A 06 00000000:00000000 03:00001278 00000000     0        0 0 3 ffff881327d97b00
 175: 68517E0A:2742 595D7E0A:5260 06 00000000:00000000 03:0000021F 00000000     0        0 0 3 ffff881438bb7500
 176: 68517E0A:2742 595D7E0A:3702 06 00000000:00000000 03:00001198 00000000     0        0 0 3 ffff881327d97800
 177: 68517E0A:2742 595D7E0A:8BD2 06 00000000:00000000 03:00000F86 00000000     0        0 0 3 ffff881438b2e500
 178: 68517E0A:2742 595D7E0A:D991 06 00000000:00000000 03:00000E41 00000000     0        0 0 3 ffff881438b71900
 179: 68517E0A:2742 595D7E0A:3B5A 06 00000000:00000000 03:000014F7 00000000     0        0 0 3 ffff881343d08300
 180: 68517E0A:2742 595D7E0A:7721 06 00000000:00000000 03:00000573 00000000     0        0 0 3 ffff881327d96f00
 181: 68517E0A:A2CA 030C310A:178E 01 00000000:00000000 00:00000000 00000000     0        0 1396086369 1 ffff881513e52b80 20 4 30 10 -1
 182: 68517E0A:32F8 68517E0A:06A4 06 00000000:00000000 03:0000049C 00000000     0        0 0 3 ffff880113dd5900
 183: 68517E0A:0016 6512F90A:E247 01 00000024:00000000 01:00000019 00000000     0        0 1413337900 4 ffff8810c551de40 25 4 31 5 4
 184: 68517E0A:B178 23677E0A:0885 01 00000000:00000000 00:00000000 00000000  1000        0 1168560402 2 ffff881085790e80 20 4 30 10 -1
 185: 68517E0A:3326 68517E0A:06A4 06 00000000:00000000 03:000011A1 00000000     0        0 0 3 ffff88148195a300
 186: 68517E0A:E894 4BC2880A:2384 01 0000004C:00000000 01:00000010 00000000  1000        0 1296545443 4 ffff880101c3ba00 20 4 1 2 2
 187: 0100007F:2329 0100007F:5E5D 06 00000000:00000000 03:00000DFC 00000000     0        0 0 3 ffff88148195a900
 188: 68517E0A:2742 595D7E0A:0E7F 06 00000000:00000000 03:0000014D 00000000     0        0 0 3 ffff88113e8d4300
 189: 68517E0A:2742 595D7E0A:D1DF 06 00000000:00000000 03:00001274 00000000     0        0 0 3 ffff881327d95400
 190: 68517E0A:2742 595D7E0A:B0C1 06 00000000:00000000 03:000015C7 00000000     0        0 0 3 ffff881327d97f00
```


inode与socket的关联
 lrwx------ 1 work work 64 Mar 22 21:59 71 -> socket:[620258669]

